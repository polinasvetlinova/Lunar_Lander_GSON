
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/GuardarGson"})
public class GuardarGson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // data: {id: newId, nm: nombre, d: dificultad, n: modeloNave, l: modeloLuna},

        String nombre = request.getParameter("nm");
        int d = Integer.parseInt(request.getParameter("d"));
        int n = Integer.parseInt(request.getParameter("n"));
        int l = Integer.parseInt(request.getParameter("l"));
        int id = Integer.parseInt(request.getParameter("id"));
        Gson gson = new Gson();
        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/jsn.json");
        FileReader f = new FileReader(fullPath);

        Configuraciones configuraciones = gson.fromJson(f, Configuraciones.class);

        Configuraciones.Config nuevaConfiguracion = new Configuraciones.Config(id, nombre, d, n, l); //creo objeto con parametros
        configuraciones.getConfig().add(nuevaConfiguracion);
        try (Writer writer = new FileWriter(fullPath)) {

            gson.toJson(configuraciones, writer);
             response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"mess\":\"Se ha guardado correctamente\"}");

        } catch (Exception e) {
                 response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"mess\":\"No se ha guardado correctamente\"}");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
