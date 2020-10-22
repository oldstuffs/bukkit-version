package io.github.portlek.bukkitversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * gets minecraft version from package version of the server.
 */
public final class BukkitVersion {

  /**
   * pattern of the server text. the pattern looks like (major)_(minor)_R(micro).
   */
  @NotNull
  private static final Pattern PATTERN =
    Pattern.compile("v?(?<major>[0-9]+)[._](?<minor>[0-9]+)(?:[._]R(?<micro>[0-9]+))?(?<sub>.*)");

  /**
   * server version text.
   */
  @NotNull
  private final String version;

  /**
   * ctor.
   *
   * @param version the version.
   */
  public BukkitVersion(@NotNull final String version) {
    this.version = version;
  }

  /**
   * ctor.
   */
  public BukkitVersion() {
    this(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1));
  }

  /**
   * obtains the raw version.
   *
   * @return raw version.
   */
  @NotNull
  public String getVersion() {
    return this.version;
  }

  /**
   * gets major part of the version.
   *
   * @return major part.
   */
  public int major() {
    return this.get("major");
  }

  /**
   * gets minor part of the version.
   *
   * @return minor part.
   */
  public int minor() {
    return this.get("minor");
  }

  /**
   * gets micro part of the version.
   *
   * @return micro part.
   */
  public int micro() {
    return this.get("micro");
  }

  /**
   * gets the part from the given key.
   *
   * @param key the key to get.
   *
   * @return the part of the given key.
   */
  private int get(@NotNull final String key) {
    final Matcher matcher = BukkitVersion.PATTERN.matcher(this.version);
    if (matcher.matches()) {
      return Integer.parseInt(matcher.group(key));
    }
    return 0;
  }
}
