package org.animefoda.client.pages;

import java.util.Arrays;

public enum FrontEndPages {
    HOME(10, "all"),
    SEARCH(20, "search");

    private final int sizePage;
    private final String path;

    FrontEndPages(int sizePage, String path) {
        this.sizePage = sizePage;
        this.path = path;
    }

    public static FrontEndPages fromPath(String path) {
        return Arrays.stream(values())
                .filter(page -> page.path.equals(path))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown path: " + path));
    }

    public int getSizePage() {
        return sizePage;
    }
    public String getPath() {
        return path;
    }
}
