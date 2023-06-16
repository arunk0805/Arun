package org.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BooksPojo {
	private int id;
	private String title;
	private String description;
	private int pageCount;
	private String excerpt;
	private String publishDate;

}
