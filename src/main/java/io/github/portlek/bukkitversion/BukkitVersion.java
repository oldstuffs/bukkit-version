/*
 * MIT License
 *
 * Copyright (c) 2021 Hasan Demirtaş
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.github.portlek.bukkitversion;

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
   * gets major part of the version.
   *
   * @return major part.
   */
  public int getMajor() {
    return this.get("major");
  }

  /**
   * gets micro part of the version.
   *
   * @return micro part.
   */
  public int getMicro() {
    return this.get("micro");
  }

  /**
   * gets minor part of the version.
   *
   * @return minor part.
   */
  public int getMinor() {
    return this.get("minor");
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
   * gets the part from the given key.
   *
   * @param key the key to get.
   *
   * @return the part of the given key.
   */
  private int get(@NotNull final String key) {
    final var matcher = BukkitVersion.PATTERN.matcher(this.version);
    return matcher.matches() ? Integer.parseInt(matcher.group(key)) : 0;
  }
}
