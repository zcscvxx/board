package com.ish.board.dao;
import java.util.ArrayList;

import com.ish.board.dto.BDto;

public interface BDao {
	public void write(String bName, String bTitle, String bContent);
	public ArrayList<BDto> list();
	public BDto contentView(String strID);
	public void modify(String bId, String bName, String bTitle, String bContent);
	public void delete(String bId);
	public BDto reply_view(String str);
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) ;
	public void replyShape( String strGroup, String strStep);
	public void upHit( String bId);
	//-------------------- 
	public int getRowNum();
	public int getMaxId();
}
