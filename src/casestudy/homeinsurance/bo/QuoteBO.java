package casestudy.homeinsurance.bo;

import java.util.ArrayList;
import java.util.List;

import casestudy.homeinsurance.dao.QuoteDAO;
import casestudy.homeinsurance.exception.MyJDBCException;
import casestudy.homeinsurance.model.Property;
import casestudy.homeinsurance.model.Quote;
import casestudy.homeinsurance.model.User;

public class QuoteBO {
	
	public List<Quote> getQuotes(User user) throws MyJDBCException
	{
		final QuoteDAO quoteDetails = new QuoteDAO();
		List<Quote> quotes = new ArrayList<Quote>();
		try
		{
			quotes = quoteDetails.getQuotes(user);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return quotes;
	}
	
	
	public Quote getQuote(final Property property) throws MyJDBCException
	{

		final QuoteDAO quoteDetails = new QuoteDAO();
		Quote quote = null;
		try
		{	
			quote = quoteDetails.getQuote(property);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return quote;
	}
	
	public void registerQuote(final Property property, final Quote quote) throws MyJDBCException
	{

		final QuoteDAO quoteDetails = new QuoteDAO();
		try
		{
			quoteDetails.registerQuote(property, quote);
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
	}
	public int getNumberOfQuotes() throws MyJDBCException{
		final QuoteDAO quoteDAO = new QuoteDAO();
		int numberofquotes = 0;
		try
		{
			numberofquotes = quoteDAO.getNumberOfQuotes();
		}
		catch(MyJDBCException e)
		{
			throw new MyJDBCException(e.getMessage());
		}
		return numberofquotes;
	}
}