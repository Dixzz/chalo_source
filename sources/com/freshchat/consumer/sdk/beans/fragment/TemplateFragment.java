package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class TemplateFragment extends MessageFragment {
    @ab.c
    private final HashMap<SectionKey, List<MessageFragment>> sectionMap = new HashMap<>();
    private List<Section> sections;
    private final String templateType;

    public static class Section {
        private List<MessageFragment> fragments;
        @SerializedName("name")
        private SectionKey sectionKey;

        public List<MessageFragment> getFragments() {
            return this.fragments;
        }

        public SectionKey getSectionKey() {
            return this.sectionKey;
        }

        public void setFragments(List<MessageFragment> list) {
            this.fragments = list;
        }

        public void setSectionKey(SectionKey sectionKey2) {
            this.sectionKey = sectionKey2;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Section{sectionKey='");
            i0.append(this.sectionKey);
            i0.append('\'');
            i0.append(", fragments=");
            i0.append(this.fragments);
            i0.append('}');
            return i0.toString();
        }
    }

    public TemplateFragment(String str) {
        super(FragmentType.TEMPLATE.asInt());
        this.templateType = str;
    }

    public List<MessageFragment> getFragmentsForSection(SectionKey sectionKey) {
        if (k.isEmpty(this.sections)) {
            return null;
        }
        if (k.c(this.sectionMap)) {
            for (Section section : this.sections) {
                this.sectionMap.put(section.getSectionKey(), section.fragments);
            }
        }
        return this.sectionMap.get(sectionKey);
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public MessageFragment getSingleFragmentFromSection(SectionKey sectionKey) {
        List<MessageFragment> fragmentsForSection = getFragmentsForSection(sectionKey);
        if (k.a(fragmentsForSection)) {
            return fragmentsForSection.get(0);
        }
        return null;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public void replaceSection(SectionKey sectionKey, List<MessageFragment> list) {
        if (!k.isEmpty(this.sections)) {
            this.sectionMap.clear();
            Section section = null;
            Iterator<Section> it = this.sections.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Section next = it.next();
                if (next.getSectionKey() == sectionKey) {
                    section = next;
                    break;
                }
            }
            if (section != null) {
                this.sections.remove(section);
            }
            Section section2 = new Section();
            section2.setSectionKey(sectionKey);
            section2.setFragments(list);
            this.sections.add(section2);
        }
    }

    public void setSections(List<Section> list) {
        this.sections = list;
        this.sectionMap.clear();
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("TemplateFragment{messageFragment='");
        hj1.U0(i0, super.toString(), '\'', ", templateType='");
        hj1.U0(i0, this.templateType, '\'', ", sections=");
        i0.append(this.sections);
        i0.append(", sectionMap=");
        i0.append(this.sectionMap);
        i0.append('}');
        return i0.toString();
    }
}
