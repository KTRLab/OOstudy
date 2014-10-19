/**
 *
 */
package builder.concrete;

import java.util.List;

import builder.framework.Builder;

/**
 * @author mitsuik
 *
 */
public class BuilderXML extends Builder {

	/*
	 * XMLオブジェクトを利用するのは別途
	 */
	private StringBuilder stbuf = new StringBuilder("");

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildTitle(java.lang.String)
	 * StringUtilsは、ジャカルタの外部ユーティリティです。非常に便利。
	 */
	@Override
	public void buildTitle(String _title) {
		stbuf.append("<TITLE value=\"" + _title + "\">" + "\n");

	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildString(java.lang.String)
	 */
	@Override
	public void buildSubTitle(String _buf) {
		stbuf.append(" <SUBTITLE weekday=\"" + _buf + "\">");
		stbuf.append("\n");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildContents(builder.framework.Template)
	 */
	@Override
	public void buildContentsTitle(String _buf) {
		stbuf.append("  <CONTENTS GARBAGE=\"" + _buf + "\"");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildItems(java.lang.String[])
	 */
	@Override
	public void buildContentsItems(List<String> _items) {
		stbuf.append(" HOW=\"" + _items.get(0) + "\" WHERE=\"" + _items.get(1) + "\" WHEN=\"" + _items.get(2) + "\">\n");
		stbuf.append("  </CONTENTS>");
		stbuf.append("\n");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildClose()
	 */
	@Override
	public void buildClose() {
		stbuf.append("</TITLE>" + "\n");
		stbuf.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		System.out.println(this.stbuf);
	}

	@Override
	public void buildSubTitleClose() {
		stbuf.append(" </SUBTITLE>");
		stbuf.append("\n");
	}

}
