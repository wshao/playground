package co.uk.powersquare.pojo;
import java.util.List;
/**
 * Created by wshao on 29/06/2017.
 */
public class AlgoliaResponse
{
    List<Document> hits;

    String nbHits;

    String query;

    String params;

    public List<Document> getHits()
    {
        return hits;
    }
    public void setHits(List<Document> hits)
    {
        this.hits = hits;
    }
    public String getNbHits()
    {
        return nbHits;
    }
    public void setNbHits(String nbHits)
    {
        this.nbHits = nbHits;
    }
    public String getQuery()
    {
        return query;
    }
    public void setQuery(String query)
    {
        this.query = query;
    }
    public String getParams()
    {
        return params;
    }
    public void setParams(String params)
    {
        this.params = params;
    }
}
