package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebcollectionMapper;
import wcmc.schoolcard.dto.Webcollection;
import wcmc.schoolcard.dto.WebcollectionKey;
import wcmc.schoolcard.service.WebCollectionService;

import java.util.List;


@Service
public class WebCollectionServiceImpl implements WebCollectionService{
    @Autowired
    private WebcollectionMapper webcollectionMapper;
    @Override
    public List<Webcollection> selectByReaderId(String readerid){
        return webcollectionMapper.selectByReaderId(readerid);
    };
    @Override
    public int deleteByPrimaryKey(WebcollectionKey key){
        return webcollectionMapper.deleteByPrimaryKey(key);
    };

    @Override
    public int insert(Webcollection webcollection){return webcollectionMapper.insert(webcollection);};

    @Override
    public List<String> selectBookidByReaderId(String readerid){
        return webcollectionMapper.selectBookidByReaderId(readerid);
    };
}
