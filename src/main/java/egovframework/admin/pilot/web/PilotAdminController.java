package egovframework.admin.pilot.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PilotAdminController {

    /**
     * GIS 화면
     */
    @GetMapping(value = "/admin/pilot/gis")
    public ModelAndView gisView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/pilot/gisView");
        return mav;
    }

    /**
     * editor 화면
     */
    @GetMapping(value = "/admin/pilot/editor")
    public ModelAndView editorView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/pilot/editorView");
        return mav;
    }

    /**
     * editor 화면
     */
    @GetMapping(value = "/admin/pilot/viewer")
    public ModelAndView viewerView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/pilot/viewerView");
        return mav;
    }
}
