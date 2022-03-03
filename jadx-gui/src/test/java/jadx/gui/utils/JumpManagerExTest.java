package jadx.gui.utils;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jadx.gui.treemodel.TextNode;

import static org.hamcrest.Matchers.is;

/*
 * test JumpMangerEx
 * which extends JumpManger and replace private ignoreJump method with new one
 */
class JumpManagerExTest {

	private JumpManagerEx jm;
	JumpPosition pos1 = new JumpPosition(new TextNode("aa"), 3, 1);
	JumpPosition pos2 = new JumpPosition(new TextNode("bb"), 0, 2);
	JumpPosition pos2Line0 = new JumpPosition(pos2.getNode(), 0, 2);
	JumpPosition pos2Line8 = new JumpPosition(pos2.getNode(), 8, 2);
	JumpPosition pos2Line12 = new JumpPosition(pos2.getNode(), 12, 2);

	@BeforeEach
	public void setup() throws NoSuchFieldException, NoSuchMethodException {
		jm = new JumpManagerEx();// dynamic reload
	}

	@Test
	public void testIgnoreJump() {
		// @null
		// test if ignore a jumpPosition when browsing history is empty
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos1), is(false));
		jm.addPosition(pos1);
		// @1
		// test if ignore a same jumpPosition (same decompiled class)
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos1), is(true));
		// test if ignore a jumpPosition when browsing history is not empty
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos2), is(false));
		jm.addPosition(pos2);
		// 1 - @2 line0
		// test if ignore a similar jumpPosition (same decompiled class) and click 1 method in line 8
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos2Line8), is(false));
		// 1 - @2 line8
		jm.addPosition(pos2Line8);
		// test if ignore a similar jumpPosition (same decompiled class) and does not click any method or
		// filed
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos2Line0), is(true));
		// test if ignore a similar jumpPosition (same decompiled class) and click 1 method in line 12
		MatcherAssert.assertThat(jm.ignoreJumpPublic(pos2Line12), is(false));
	}
}
