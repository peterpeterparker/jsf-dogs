import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Named("dogs")
@ViewScoped
public class DogsBean implements Serializable {

	private DogDTO dog;

	public void load() {
		final String jsonData = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dog");

		final Gson gson = new GsonBuilder().create();

		dog = gson.fromJson(jsonData, DogDTO.class);
	}

	public DogDTO getDog() {
		return dog;
	}
}