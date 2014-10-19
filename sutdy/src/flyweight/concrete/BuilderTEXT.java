/**
 *
 */
package flyweight.concrete;

import flyweight.framework.Builder;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mitsuik
 *
 */
public class BuilderTEXT extends Builder {

	/*
	 * 追加変更される文字列ならStringBuilderクラスを使いましょう。
	 * Stringへの追加変更より高速です。
	 * StringBufferのほうが、歴史が古くスレッドセーフです。
	 * スレッドセーフが必要でないなら、StringBuilderのほうが高速です。
	 */
	private StringBuilder stbuf = new StringBuilder("");

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildTitle(java.lang.String)
	 * StringUtilsは、ジャカルタの外部ユーティリティです。非常に便利。
	 */
	@Override
	public void buildTitle(String _title) {
		final int TITLE_WIDTH = 40;
		// TODO 奇数処理が抜けている
		final int TITLE_PART_DECO_WIDTH = (TITLE_WIDTH - StringUtils.length(_title)) / 2 - 6;
		stbuf.append(StringUtils.repeat("*", TITLE_WIDTH) + "\n");
		stbuf.append(StringUtils.repeat("*",3));
		stbuf.append(StringUtils.repeat(" ", TITLE_PART_DECO_WIDTH));
		stbuf.append(" [ " + _title + " ] ");
		stbuf.append(StringUtils.repeat(" ", TITLE_PART_DECO_WIDTH));
		stbuf.append(StringUtils.repeat("*",3));
		stbuf.append("\n");
		stbuf.append(StringUtils.repeat("*", TITLE_WIDTH) + "\n");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildString(java.lang.String)
	 */
	@Override
	public void buildSubTitle(String _buf) {
		stbuf.append(" [ " + _buf + " ] ");
		stbuf.append("\n");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildContents(builder.framework.Template)
	 */
	@Override
	public void buildContentsTitle(String _buf) {
		stbuf.append("◆" + _buf + "◆");
		stbuf.append("\n");
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildItems(java.lang.String[])
	 */
	@Override
	public void buildContentsItems(List<String> _items) {
		for (String st : _items) {
			stbuf.append("｜" + st);
			stbuf.append("\n");
		}
	}

	/* (非 Javadoc)
	 * @see builder.framework.Builder#buildClose()
	 */
	@Override
	public void buildClose() {
		System.out.println(this.stbuf);

	}

	@Override
	public void buildSubTitleClose() {
		stbuf.append("◆");
		stbuf.append("\n");
	}

}
