package io.github.gobunge.api.enumerate;

public enum Gallery {
    DCINSIDE_VINDICTUS_TIP("mi$vindictus"),
    DCINSIDE_VINDICTUS("mabi_heroes2");

    private final String code;

    Gallery(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
