package wcmc.schoolcard.service;


import wcmc.schoolcard.dto.Webborrow;

import java.util.List;


public interface WebBorrowService {
    public List<Webborrow>  selectByReaderId(String readerid);

}
