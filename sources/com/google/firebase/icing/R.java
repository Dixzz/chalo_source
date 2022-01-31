package com.google.firebase.icing;

public final class R {

    public static final class attr {
        public static final int allowShortcuts = 2130968620;
        public static final int contentProviderUri = 2130968823;
        public static final int corpusId = 2130968839;
        public static final int corpusVersion = 2130968840;
        public static final int defaultIntentAction = 2130968898;
        public static final int defaultIntentActivity = 2130968899;
        public static final int defaultIntentData = 2130968900;
        public static final int documentMaxAgeSecs = 2130968919;
        public static final int featureType = 2130968988;
        public static final int indexPrefixes = 2130969209;
        public static final int inputEnabled = 2130969219;
        public static final int noIndex = 2130969451;
        public static final int paramName = 2130969473;
        public static final int paramValue = 2130969474;
        public static final int perAccountTemplate = 2130969482;
        public static final int schemaOrgProperty = 2130969529;
        public static final int schemaOrgType = 2130969530;
        public static final int searchEnabled = 2130969536;
        public static final int searchLabel = 2130969539;
        public static final int sectionContent = 2130969541;
        public static final int sectionFormat = 2130969542;
        public static final int sectionId = 2130969543;
        public static final int sectionType = 2130969544;
        public static final int sectionWeight = 2130969545;
        public static final int semanticallySearchable = 2130969551;
        public static final int settingsDescription = 2130969552;
        public static final int sourceClass = 2130969599;
        public static final int subsectionSeparator = 2130969628;
        public static final int toAddressesSection = 2130969739;
        public static final int trimmable = 2130969768;
        public static final int userInputSection = 2130969800;
        public static final int userInputTag = 2130969801;
        public static final int userInputValue = 2130969802;

        private attr() {
        }
    }

    public static final class id {
        public static final int contact = 2131296754;
        public static final int date = 2131296793;
        public static final int demote_common_words = 2131296803;
        public static final int demote_rfc822_hostnames = 2131296804;
        public static final int email = 2131296929;
        public static final int html = 2131297276;
        public static final int icon_uri = 2131297283;
        public static final int index_entity_types = 2131297294;
        public static final int instant_message = 2131297310;
        public static final int intent_action = 2131297311;
        public static final int intent_activity = 2131297312;
        public static final int intent_data = 2131297313;
        public static final int intent_data_id = 2131297314;
        public static final int intent_extra_data = 2131297315;
        public static final int large_icon_uri = 2131297341;
        public static final int match_global_nicknames = 2131297412;
        public static final int omnibox_title_section = 2131297606;
        public static final int omnibox_url_section = 2131297607;
        public static final int plain = 2131297757;
        public static final int rfc822 = 2131297982;
        public static final int text1 = 2131298309;
        public static final int text2 = 2131298310;
        public static final int thing_proto = 2131298334;
        public static final int url = 2131298488;

        private id() {
        }
    }

    public static final class styleable {
        public static final int[] AppDataSearch = new int[0];
        public static final int[] Corpus = {app.zophop.R.attr.contentProviderUri, app.zophop.R.attr.corpusId, app.zophop.R.attr.corpusVersion, app.zophop.R.attr.documentMaxAgeSecs, app.zophop.R.attr.perAccountTemplate, app.zophop.R.attr.schemaOrgType, app.zophop.R.attr.semanticallySearchable, app.zophop.R.attr.trimmable};
        public static final int Corpus_contentProviderUri = 0;
        public static final int Corpus_corpusId = 1;
        public static final int Corpus_corpusVersion = 2;
        public static final int Corpus_documentMaxAgeSecs = 3;
        public static final int Corpus_perAccountTemplate = 4;
        public static final int Corpus_schemaOrgType = 5;
        public static final int Corpus_semanticallySearchable = 6;
        public static final int Corpus_trimmable = 7;
        public static final int[] FeatureParam = {app.zophop.R.attr.paramName, app.zophop.R.attr.paramValue};
        public static final int FeatureParam_paramName = 0;
        public static final int FeatureParam_paramValue = 1;
        public static final int[] GlobalSearch = {app.zophop.R.attr.defaultIntentAction, app.zophop.R.attr.defaultIntentActivity, app.zophop.R.attr.defaultIntentData, app.zophop.R.attr.searchEnabled, app.zophop.R.attr.searchLabel, app.zophop.R.attr.settingsDescription};
        public static final int[] GlobalSearchCorpus = {app.zophop.R.attr.allowShortcuts};
        public static final int GlobalSearchCorpus_allowShortcuts = 0;
        public static final int[] GlobalSearchSection = {app.zophop.R.attr.sectionContent, app.zophop.R.attr.sectionType};
        public static final int GlobalSearchSection_sectionContent = 0;
        public static final int GlobalSearchSection_sectionType = 1;
        public static final int GlobalSearch_defaultIntentAction = 0;
        public static final int GlobalSearch_defaultIntentActivity = 1;
        public static final int GlobalSearch_defaultIntentData = 2;
        public static final int GlobalSearch_searchEnabled = 3;
        public static final int GlobalSearch_searchLabel = 4;
        public static final int GlobalSearch_settingsDescription = 5;
        public static final int[] IMECorpus = {app.zophop.R.attr.inputEnabled, app.zophop.R.attr.sourceClass, app.zophop.R.attr.toAddressesSection, app.zophop.R.attr.userInputSection, app.zophop.R.attr.userInputTag, app.zophop.R.attr.userInputValue};
        public static final int IMECorpus_inputEnabled = 0;
        public static final int IMECorpus_sourceClass = 1;
        public static final int IMECorpus_toAddressesSection = 2;
        public static final int IMECorpus_userInputSection = 3;
        public static final int IMECorpus_userInputTag = 4;
        public static final int IMECorpus_userInputValue = 5;
        public static final int[] Section = {app.zophop.R.attr.indexPrefixes, app.zophop.R.attr.noIndex, app.zophop.R.attr.schemaOrgProperty, app.zophop.R.attr.sectionFormat, app.zophop.R.attr.sectionId, app.zophop.R.attr.sectionWeight, app.zophop.R.attr.subsectionSeparator};
        public static final int[] SectionFeature = {app.zophop.R.attr.featureType};
        public static final int SectionFeature_featureType = 0;
        public static final int Section_indexPrefixes = 0;
        public static final int Section_noIndex = 1;
        public static final int Section_schemaOrgProperty = 2;
        public static final int Section_sectionFormat = 3;
        public static final int Section_sectionId = 4;
        public static final int Section_sectionWeight = 5;
        public static final int Section_subsectionSeparator = 6;

        private styleable() {
        }
    }

    private R() {
    }
}
