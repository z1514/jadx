package jadx.tests.integration.conditions;

import java.util.zip.ZipEntry;

import org.junit.jupiter.api.Test;

import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.assertj.JadxAssertions.assertThat;

public class TestAssignInlineNegative extends IntegrationTest {

	@SuppressWarnings("ConstantConditions")
	public static class TestCls {

		public final ZipEntry test() {
			ZipEntry nextEntry = getNextEntry();
			if (nextEntry == null) {
				return nextEntry;
			}
			String name = nextEntry.getName();
			if (name == null) {
				return nextEntry;
			}
			if (!name.contains("../") && !name.contains("..\\")) {
				return nextEntry;
			}
			throw new SecurityException(":" + nextEntry.getName());
		}

		private ZipEntry getNextEntry() {
			return null;
		}
	}

	@Test
	public void test() {
		noDebugInfo();
		assertThat(getClassNode(TestCls.class))
				.code()
				.doesNotContain("(name = nextEntry.getName()) == null")
				.containsOne("if (name == null) {");
	}
}
