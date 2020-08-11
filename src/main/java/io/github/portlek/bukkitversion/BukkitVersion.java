package io.github.portlek.bukkitversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * Gets minecraft version from
 * package version of the server.
 */
@RequiredArgsConstructor
public final class BukkitVersion {

    /**
     * Pattern of the server text
     * <p>
     * The pattern is like that
     * (major)_(minor)_R(micro)
     */
    @NotNull
    private static final Pattern PATTERN =
        Pattern.compile("v?(?<major>[0-9]+)[._](?<minor>[0-9]+)(?:[._]R(?<micro>[0-9]+))?(?<sub>.*)");

    /**
     * Server version text
     */
    @NotNull
    @Getter
    private final String version;

    /**
     * Initiates with current running server package name
     */
    public BukkitVersion() {
        this(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1));
    }

    /**
     * Gets major part of the version
     *
     * @return major part
     */
    public int major() {
        return this.get("major");
    }

    /**
     * Gets minor part of the version
     *
     * @return minor part
     */
    public int minor() {
        return this.get("minor");
    }

    /**
     * Gets micro part of the version
     *
     * @return micro part
     */
    public int micro() {
        return this.get("micro");
    }

    private int get(@NotNull final String key) {
        final Matcher matcher = BukkitVersion.PATTERN.matcher(this.version);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(key));
        }
        return 0;
    }

}
