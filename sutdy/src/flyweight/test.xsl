<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="Shift_JIS"/>

  <xsl:template match="/TITLE">
    <xsl:comment>
      <xsl:text>コメントです</xsl:text>
    </xsl:comment>
    <xsl:element name="HTML">
      <xsl:element name="BODY">
		<xsl:apply-templates select="SUBTITLE"/>
      </xsl:element>
    </xsl:element>
  </xsl:template> 

  <xsl:template match="SUBTITLE">
    <xsl:element name="SUBTITLE">
      <xsl:attribute name="weekday">
<!--        <xsl:value-of select="weekday"/>-->
      </xsl:attribute>
    </xsl:element>
  </xsl:template> 

</xsl:stylesheet>
