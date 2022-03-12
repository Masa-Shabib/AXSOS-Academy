
public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		super.getAuthor();
		// TODO Auto-generated method stub
		System.out.println("Title: "+this.title+"Author: "+this.author+"Description: "+this.description+"Type: "+this.paintType);
	}

}
