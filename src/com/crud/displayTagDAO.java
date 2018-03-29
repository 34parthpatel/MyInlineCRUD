package com.crud;


public class displayTagDAO {

	public displayTag getPaginatedList(displayTag disTag)
	{
		int pageNum = disTag.getPageNumber();
		
		final int objectPerPage = disTag.getObjectsPerPage();
		final int firstRasult = objectPerPage * pageNum;
		String sortOrderCriterion = disTag.getSortCriterion();
		
		/*String className = */
		
		return disTag;
	}
}
