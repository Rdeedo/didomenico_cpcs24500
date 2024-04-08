package a6;

public class ThreeDNode extends Node{

    private int z;

	public ThreeDNode() throws Exception {
		this (DEFAULT_X, DEFAULT_Y, DEFAULT_Z);
	}
	
	public ThreeDNode(int x, int y, int z) throws Exception {
		super(x, y);
		setZ(z);
	}
	
	public ThreeDNode(ThreeDNode node) throws Exception {
		super(node);
		setZ(node.getZ());
	}
		
	public int getX() {
		return super.getX();
	}

	public void setX(int x) throws Exception {
		super.setX(x);
	}
	
	public int getY() {
		return super.getY();
	}

	public void setY(int y) throws Exception {
		super.setY(y);
		}

	private boolean isValidZ(int z) {
		if (z<=UPPER_LIMIT && z>=LOWER_LIMIT)
			return true;
		return false;
	}

	public void setZ(int z) throws Exception {
		if (isValidZ(z))
			this.z = z;
		else
		throw new Exception("Invalid operation: z value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
	}
	
	public int getZ() {
		return z;
	}
	
	public void add(ThreeDNode node) throws Exception {
		if (isValidZ(this.z+node.getZ())) {
			super.add(node);
			this.z += node.getZ();
		} else 
			throw new Exception("Invalid operation, the result exceeds the xyz-space boundaries...");
	}
	
	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ", " + this.z + ")";
	}

	@Override
	public boolean equals(Object obj) {
		//to restrict call with only objects of type Node
		if (obj instanceof ThreeDNode) {
			ThreeDNode ref = (ThreeDNode) obj;
			if (getX()==ref.getX() && getY() == ref.getY() && this.z == ref.z)
				return true;
			return false;
		}
		return false;
	}

}
