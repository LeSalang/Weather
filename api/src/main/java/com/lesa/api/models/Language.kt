package com.lesa.api.models

enum class Language(val value: String) {
    ARABIC("ar"),
    BENGALI("bn"),
    BULGARIAN("bg"),
    CHINESE_SIMPLIFIED("zh"),
    CHINESE_TRADITIONAL("zh_tw"),
    CZECH("cs"),
    DANISH("da"),
    DUTCH("nl"),
    FINNISH("fi"),
    FRENCH("fr"),
    GERMAN("de"),
    GREEK("el"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    ITALIAN("it"),
    JAPANESE("ja"),
    JAVANESE("jv"),
    KOREAN("ko"),
    MANDARIN("zh_cmn"),
    MARATHI("mr"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SERBIAN("sr"),
    SINHALESE("si"),
    SLOVAK("sk"),
    SPANISH("es"),
    SWEDISH("sv"),
    TAMIL("ta"),
    TELUGU("te"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    URDU("ur"),
    VIETNAMESE("vi"),
    WU_SHANGHAINESE("zh_wuu"),
    XIANG("zh_hsn"),
    YUE_CANTONESE("zh_yue"),
    ZULU("zu");

    companion object {
        fun fromCode(code: String): Language? {
            return entries.find { it.value == code }
        }
    }
}
