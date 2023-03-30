package business.businessObjects;

import java.sql.Date;

public class AdvertisementBO {
	private int id;
	private String title;
	private String content;
	private int categoryId;
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public AdvertisementBO(int id, String title, String content, int categoryId, Date createDate) {
		setId(id);
		setTitle(title);
		setContent(content);
		setCategoryId(categoryId);
		setCreateDate(createDate);
	}
}