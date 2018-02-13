package bulebar.reservacion.appbarserver.Common;

/**
 * Created by MDJ16 on 12/02/2018.
 */

import bulebar.reservacion.appbarserver.model.Request;
import bulebar.reservacion.appbarserver.model.User;

public class Common {

    public static  User currentUser;
    public static Request currentRequest;


    public static final String UPDATE = "Actualizar";
    public static final String DELETE = "Borrar";

    public static  final int PICK_IMAGE_REQUEST = 71;

    public static String convertCodeToStatus(String code){
        if(code.equals("0"))
            return "Placed";
        else if(code.equals("1"))
            return "On my way";
        else
            return "Shipped";
    }


}
