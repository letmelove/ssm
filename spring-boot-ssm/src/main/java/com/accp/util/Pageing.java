package com.accp.util;

import java.util.ArrayList;
import java.util.List;

public class Pageing<T> {

	private Integer countTwig; // 总条数
	private Integer countPage; // 总页数
	private Integer currentPage = 1; // 当前页
	private Integer showTwig = 2; // 每页显示多少条
	private List<T> list = new ArrayList<T>(); // 显示的数据

	public Integer getCountTwig() {
		return countTwig;
	}

	public void setCountTwig(Integer countTwig) {
		this.countTwig = countTwig;
	}

	public Integer getCountPage() {
		countPage = countTwig % showTwig == 0 ? countTwig / showTwig : countTwig / showTwig + 1;
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getShowTwig() {
		return showTwig;
	}

	public void setShowTwig(Integer showTwig) {
		this.showTwig = showTwig;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
