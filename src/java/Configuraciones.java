
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuraciones {

    @SerializedName("config")
    @Expose
    private List<Config> config = null;

    public List<Config> getConfig() {
        return config;
    }

    public void setConfig(List<Config> config) {
        this.config = config;
    }

    public static class Config {
                

        @SerializedName("id")
        @Expose
        private Integer id;       
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("dificultad")
        @Expose
        private Integer dificultad;
        @SerializedName("nave")
        @Expose
        private Integer nave;
        @SerializedName("luna")
        @Expose
        private Integer luna;
        
        //constructor vacio
        public Config(){}
        
        //constructor con parametros
        public Config (int id, String nom, int dif, int nav, int lun){
            this.id=id;
            this.nombre=nom;
            this.dificultad=dif;
            this.nave = nav;
            this.luna= lun;
        }
        
        
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getDificultad() {
            return dificultad;
        }

        public void setDificultad(Integer dificultad) {
            this.dificultad = dificultad;
        }

        public Integer getNave() {
            return nave;
        }

        public void setNave(Integer nave) {
            this.nave = nave;
        }

        public Integer getLuna() {
            return luna;
        }

        public void setLuna(Integer luna) {
            this.luna = luna;
        }

    }

}
