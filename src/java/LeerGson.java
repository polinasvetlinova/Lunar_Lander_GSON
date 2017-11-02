
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LeerGson"})
public class LeerGson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            Gson gson = new Gson();
            ServletContext context = getServletContext();
            String fullPath = context.getRealPath("/jsn.json");
            FileReader f = new FileReader(fullPath);


            Configuraciones configuraciones = gson.fromJson(f, Configuraciones.class);
            String json = gson.toJson(configuraciones);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(json);

        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Ha sido imposible recuperar los datos\"}");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
