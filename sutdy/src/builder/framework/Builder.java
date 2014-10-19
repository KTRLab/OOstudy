package builder.framework;

import java.util.List;

/*
 * 作成する目的物をつくるために必要な構成物を定義する。
 * ものによって、構成物の作り方が違うので、具体的な処理は具象継承したクラスに任せる。
 * この定義を通して、構成物の作り方とDirectorとなる作り方とつなげる。
 */
public abstract class Builder {

	public abstract void buildTitle(String _title);
	public abstract void buildSubTitle(String _buf);
	public abstract void buildSubTitleClose();
	public abstract void buildContentsTitle(String _buf);
	public abstract void buildContentsItems(List<String> _items);
	public abstract void buildClose();

}
