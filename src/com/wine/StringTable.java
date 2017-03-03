package com.wine;

public class StringTable
{
	private int stringId;
	private String locale;
	private int textId;
	private String stringStr;
	private String groupId;
	private String usageNotes;
	
	public int getStringId() {
		return stringId;
	}
	public void setStringId(int stringId) {
		this.stringId = stringId;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public String getStringStr() {
		return stringStr;
	}
	public void setStringStr(String stringStr) {
		this.stringStr = stringStr;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getUsageNotes() {
		return usageNotes;
	}
	public void setUsageNotes(String usageNotes) {
		this.usageNotes = usageNotes;
	}
	
	@Override
	public String toString ()
	{
		return 
				String.format("String Id : %d \n Locale : %s \n Text Id : %d \n String : %s \n Group id : %s \n Usage Notes : %s", getStringId(), getLocale(), getTextId(), getStringStr(), getGroupId(), getUsageNotes());
	}
	
	@Override
	public boolean equals (Object o)
	{
		if (o instanceof StringTable)
		{
			StringTable stringTable = (StringTable) o;
			
			if (stringTable.getStringId() == this.getStringId())
			{
				if (stringTable.getTextId() == this.getTextId())
				{
					if (stringTable.getStringStr().equalsIgnoreCase(this.getStringStr()))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	@Override
	public int hashCode() 
	{
		int result = 0;
		result = 31 * result + this.getStringId();
		result = 31 * result + this.getTextId();	
		result = 31 * result + this.getStringStr().hashCode();
		
		return result;
		
	}
}