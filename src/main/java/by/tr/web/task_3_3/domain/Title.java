package by.tr.web.task_3_3.domain;

public class Title {
	private String russian;
	private String original;
	
	public Title() {

	}

	public String getRussian() {
		return russian;
	}

	public void setRussian(String russian) {
		this.russian = russian;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((russian == null) ? 0 : russian.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (russian == null) {
			if (other.russian != null)
				return false;
		} else if (!russian.equals(other.russian))
			return false;
		return true;
	}
		
	
}
