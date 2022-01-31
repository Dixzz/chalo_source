package com.rabbitmq.tools.json;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSONReader {
    private static final Object ARRAY_END = new Object();
    private static final Object COLON = new Object();
    private static final Object COMMA = new Object();
    private static final Object OBJECT_END = new Object();
    private static final Map<Character, Character> escapes;
    private final StringBuilder buf = new StringBuilder();
    private char c;
    private CharacterIterator it;
    private Object token;

    static {
        HashMap hashMap = new HashMap();
        escapes = hashMap;
        hashMap.put(new Character('\"'), new Character('\"'));
        hashMap.put(new Character('\\'), new Character('\\'));
        hashMap.put(new Character('/'), new Character('/'));
        hashMap.put(new Character('b'), new Character('\b'));
        hashMap.put(new Character('f'), new Character('\f'));
        hashMap.put(new Character('n'), new Character('\n'));
        hashMap.put(new Character('r'), new Character('\r'));
        hashMap.put(new Character('t'), new Character('\t'));
    }

    private void add(char c2) {
        this.buf.append(c2);
        next();
    }

    private void addDigits() {
        while (Character.isDigit(this.c)) {
            add();
        }
    }

    private Object array() {
        ArrayList arrayList = new ArrayList();
        Object read = read();
        while (this.token != ARRAY_END) {
            arrayList.add(read);
            if (read() == COMMA) {
                read = read();
            }
        }
        return arrayList;
    }

    private char next() {
        char next = this.it.next();
        this.c = next;
        return next;
    }

    private Object number() {
        this.buf.setLength(0);
        if (this.c == '-') {
            add();
        }
        addDigits();
        if (this.c == '.') {
            add();
            addDigits();
        }
        char c2 = this.c;
        if (c2 == 'e' || c2 == 'E') {
            add();
            char c3 = this.c;
            if (c3 == '+' || c3 == '-') {
                add();
            }
            addDigits();
        }
        String sb = this.buf.toString();
        try {
            return new Integer(sb);
        } catch (NumberFormatException unused) {
            return new Double(sb);
        }
    }

    private Object object() {
        HashMap hashMap = new HashMap();
        String str = (String) read();
        while (true) {
            Object obj = this.token;
            Object obj2 = OBJECT_END;
            if (obj == obj2) {
                return hashMap;
            }
            read();
            if (this.token != obj2) {
                hashMap.put(str, read());
                if (read() == COMMA) {
                    str = (String) read();
                }
            }
        }
    }

    private void skipWhiteSpace() {
        boolean z;
        do {
            z = true;
            if (Character.isWhitespace(this.c)) {
                next();
                continue;
            } else if (this.c == '/' && next() == '/') {
                while (this.c != '\n') {
                    next();
                }
                continue;
            } else {
                z = false;
                continue;
            }
        } while (z);
    }

    private Object string(char c2) {
        this.buf.setLength(0);
        while (true) {
            char c3 = this.c;
            if (c3 == c2) {
                next();
                return this.buf.toString();
            } else if (c3 == '\\') {
                next();
                if (this.c == 'u') {
                    add(unicode());
                } else {
                    Character ch = escapes.get(new Character(this.c));
                    if (ch != null) {
                        add(ch.charValue());
                    } else {
                        add();
                    }
                }
            } else {
                add();
            }
        }
    }

    private char unicode() {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            char next = next();
            switch (next) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i2 = ((i2 << 4) + this.c) - 48;
                    break;
                default:
                    switch (next) {
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            i = ((i2 << 4) + this.c) - 65;
                            i2 = i + 10;
                            break;
                        default:
                            switch (next) {
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i = ((i2 << 4) + this.c) - 97;
                                    i2 = i + 10;
                                    break;
                            }
                    }
            }
        }
        return (char) i2;
    }

    public Object read(String str) {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        this.it = stringCharacterIterator;
        this.c = stringCharacterIterator.first();
        return read();
    }

    private void add() {
        add(this.c);
    }

    private Object read() {
        skipWhiteSpace();
        char c2 = this.c;
        Object obj = null;
        if (c2 == '\"' || c2 == '\'') {
            next();
            obj = string(c2);
        } else if (c2 == '[') {
            next();
            obj = array();
        } else if (c2 == ']') {
            obj = ARRAY_END;
            next();
        } else if (c2 == ',') {
            obj = COMMA;
            next();
        } else if (c2 == '{') {
            next();
            obj = object();
        } else if (c2 == '}') {
            obj = OBJECT_END;
            next();
        } else if (c2 == ':') {
            obj = COLON;
            next();
        } else if (c2 == 't' && next() == 'r' && next() == 'u' && next() == 'e') {
            obj = Boolean.TRUE;
            next();
        } else if (this.c == 'f' && next() == 'a' && next() == 'l' && next() == 's' && next() == 'e') {
            obj = Boolean.FALSE;
            next();
        } else if (this.c == 'n' && next() == 'u' && next() == 'l' && next() == 'l') {
            next();
        } else if (Character.isDigit(this.c) || this.c == '-') {
            obj = number();
        } else {
            StringBuilder i0 = hj1.i0("Found invalid token while parsing JSON (around character ");
            i0.append(this.it.getIndex() - this.it.getBeginIndex());
            i0.append("): ");
            i0.append((Object) null);
            throw new IllegalStateException(i0.toString());
        }
        this.token = obj;
        return obj;
    }
}
