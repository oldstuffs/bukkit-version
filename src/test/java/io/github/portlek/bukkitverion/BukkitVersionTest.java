package io.github.portlek.bukkitverion;

import io.github.portlek.bukkitversion.BukkitVersion;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

final class BukkitVersionTest {

  private static final String MC_VERSION = "1_8_R3";

  private static final BukkitVersion VERSION = new BukkitVersion(BukkitVersionTest.MC_VERSION);

  @Test
  void getVersion() {
    MatcherAssert.assertThat(
      "Cannot get the raw version",
      BukkitVersionTest.VERSION.getVersion(),
      new IsEqual<>(BukkitVersionTest.MC_VERSION)
    );
  }

  @Test
  void major() {
    MatcherAssert.assertThat(
      "Cannot get the major  version",
      BukkitVersionTest.VERSION.major(),
      new IsEqual<>(1)
    );
  }

  @Test
  void minor() {
    MatcherAssert.assertThat(
      "Cannot get the minor version",
      BukkitVersionTest.VERSION.minor(),
      new IsEqual<>(8)
    );
  }

  @Test
  void micro() {
    MatcherAssert.assertThat(
      "Cannot get the micro version",
      BukkitVersionTest.VERSION.micro(),
      new IsEqual<>(3)
    );
  }
}
