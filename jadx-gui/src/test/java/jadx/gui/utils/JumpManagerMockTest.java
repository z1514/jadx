package jadx.gui.utils;

import jadx.gui.treemodel.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/*
* mock JumpManager in junit test
* */
class JumpManagerMockTest {

	private JumpManager jm;

	JumpPosition pos1 = new JumpPosition(new TextNode("aa"), 3, 1);
	JumpPosition spy1 = spy(pos1);
	JumpPosition pos2 = new JumpPosition(new TextNode("bb"), 4, 2);
	JumpPosition spy2 = spy(pos2);
	JumpPosition pos3 = new JumpPosition(new TextNode("cc"), 5, 3);
	JumpPosition spy3 = spy(pos3);
	@BeforeEach
	public void setup() {
		jm = mock(JumpManager.class);//dynamic reload
	}

	@Test
	public void testMockInvoked(){
		jm.addPosition(spy1);
		jm.addPosition(spy2);
		jm.addPosition(spy1);
		jm.addPosition(spy3);
		verify(jm, times(2)).addPosition(spy1);
		verify(jm, times(1)).addPosition(spy3);
	}
	@Test
	public void testMockInOrder(){
		jm.addPosition(spy1);
		jm.addPosition(spy2);
		jm.addPosition(spy1);
		jm.addPosition(spy3);
		InOrder inOrder = inOrder(jm, spy1, spy2, spy3);
		inOrder.verify(jm).addPosition(spy1);
		inOrder.verify(jm).addPosition(spy2);
		inOrder.verify(jm).addPosition(spy1);
		inOrder.verify(jm).addPosition(spy3);
		verifyNoMoreInteractions(jm);
	}

}
