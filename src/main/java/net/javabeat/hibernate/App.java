package net.javabeat.hibernate;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
/**
 * Main class
 *
 */
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        App app = new App();

        Osoba osoba = new Osoba();
        osoba.setImie("Kate");
        Adres address1 = new Adres("White Road");
        
        ArrayList<Telefon> telefons = new ArrayList<Telefon>();
        telefons.add(new Telefon("123456789",osoba,"Orange"));
        telefons.add(new Telefon("987654321",osoba,"Play"));
        
        app.saveOsobaInfo(osoba, address1, telefons);
 
        Osoba osoba2 = new Osoba();
        osoba2.setImie("Mark");
        Adres address2 = new Adres("Black Road");
        
        ArrayList<Telefon> telefons2 = new ArrayList<Telefon>();
        telefons2.add(new Telefon("456321789",osoba2,"Plus"));
        telefons2.add(new Telefon("963258741",osoba2,"T-Mobile"));
        
        app.saveOsobaInfo(osoba2, address2, telefons2);
        app.listOsobaInfo();
    }
 
    /*
     * Save the data to database table
     */
    public Long saveOsobaInfo(Osoba osoba, Adres address, ArrayList<Telefon> telefons) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long osobaId = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            osoba.setAdres(address);
            address.setOsoba(osoba);

            osoba.setTelefony(telefons);
            session.save(osoba);
 
            transaction.commit();
        	session.flush();
            
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
        	session.flush();
            session.close();
        }
        return osobaId;
    }
 
    /*
     * Lists the osoba's from database table
     */
    public void listOsobaInfo() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try 
        {
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Osoba> osobaList = session.createQuery("from Osoba").list();
            for (Iterator<Osoba> iterator = osobaList.iterator(); iterator.hasNext();) 
            {
                Osoba osoba = (Osoba) iterator.next();
                System.out.println("Imiê: "+osoba.getImie());
                System.out.println("Adres: "+osoba.getAdres().getUlica());
                System.out.println("Numery telefonów: ");
 
                for (Iterator<Telefon> iterator2 = osoba.getTelefony().iterator(); iterator2.hasNext();) 
                {
                	Telefon telefon = (Telefon) iterator2.next();
                	System.out.println(telefon.getnumer()+" "+telefon.getoperator());
                }

            	System.out.println("");
            }
            transaction.commit();
        } 
        catch (HibernateException e) 
        {
            transaction.rollback();
            e.printStackTrace();
        } 
        finally 
        {
            session.close();
        }
    }
 
}