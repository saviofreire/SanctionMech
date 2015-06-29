package CaseStudyIsrael2;

public class Table extends Block {

	Block blocks[]=new Block[3];
	
	public Table(){
		super("table");
		blocks[0]=new Block("A");
		blocks[1]=new Block("B");
		blocks[2]=new Block("C");
		
		blocks[0].setOn(this);
		blocks[1].setOn(this);
		blocks[2].setOn(this);
		
		//blocks[0].setUp(findBlock("C"));
		
		
	}
	
	public Block findBlock(String name){
		for (Block bl:blocks){
			if (bl.getName().equalsIgnoreCase(name))
				return bl;
		}
		return null;
	}
	
	public void move(Block ba, Block bb, Block bc) {
		if (ba!=null && bb!=null && bc!=null){
				bb.setUp(null);
				bc.setUp(ba);
				ba.setOn(bc);
		}
	}
}
