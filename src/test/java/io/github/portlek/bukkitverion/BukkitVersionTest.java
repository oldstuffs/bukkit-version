package io.github.portlek.bukkitverion;

import io.github.portlek.bukkitversion.BukkitVersion;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;

final class BukkitVersionTest {

  private static final String MC_VERSION = "1_8_R3";

  private static final BukkitVersion VERSION = new BukkitVersion(BukkitVersionTest.MC_VERSION);

  @Test
  void getVersion() {
    new Assertion<>(
      "Cannot get the raw version",
      BukkitVersionTest.VERSION.getVersion(),
      new IsEqual<>(BukkitVersionTest.MC_VERSION)
    ).affirm();
  }

  @Test
  void major() {
    new Assertion<>(
      "Cannot get the major  version",
      BukkitVersionTest.VERSION.getMajor(),
      new IsEqual<>(1)
    ).affirm();
  }

  @Test
  void minor() {
    new Assertion<>(
      "Cannot get the minor version",
      BukkitVersionTest.VERSION.getMinor(),
      new IsEqual<>(8)
    ).affirm();
  }

  @Test
  void micro() {
    new Assertion<>(
      "Cannot get the micro version",
      BukkitVersionTest.VERSION.getMicro(),
      new IsEqual<>(3)
    ).affirm();
  }
}
