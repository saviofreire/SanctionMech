package CaseStudyIsrael2;

public class Block {
	protected String name;
	protected Block on=null;//This está sobre no;
	protected Block up=null;//This está em baixo de up. Se é null o bloco é clear
	
	public Block() {
		super();
		this.name = null;
	}
	
	public Block(String name) {
		super();
		this.name = name;
	}
	
	public Block(String name, Block on, Block up) {
		super();
		this.name = name;
		this.on = on;
		this.up = up;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Block getOn() {
		return on;
	}

	public void setOn(Block on) {
		this.on = on;
	}

	public Block getUp() {
		return up;
	}

	public void setUp(Block up) {
		this.up = up;
	}
	
	public boolean isClear(){
		return up == null;
	}
	
}
