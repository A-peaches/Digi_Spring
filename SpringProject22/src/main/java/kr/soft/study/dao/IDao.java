package kr.soft.study.dao;

import java.util.ArrayList;

import kr.soft.study.dto.BDto;

public interface IDao {
	public ArrayList<BDto> list();
	public BDto contentView(String bId);
	public void write(final int maxCount,final String bName, final String bTitle, final String bContent);
	public void delete(final String bId);
	public void modify(final String bName, final String bTitle, final String bContent,final int bId);
	public void upHit(final String bId);
	public BDto reply_view(String str);
	public void reply(final String bName, final String bTitle, final String bContent,
			final String bGroup, final String bStep, final String bIndent);
	public void replyShape( final String strGroup, final String strStep);
	public int maxCount();
	
}
