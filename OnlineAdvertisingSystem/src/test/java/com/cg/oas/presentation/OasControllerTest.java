package com.cg.oas.presentation;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;
import com.cg.oas.presentation.OasController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class OasControllerTest 
{
	private static OasController oasController;
	private static Logger logger;
	@BeforeClass
	public static void setUp() 
	{
		logger = LogManager.getLogger(OasControllerTest.class.getName());
		oasController = new OasController();
	}
	@Test
	public void testNameAddSuccess() throws NameIsBlankException
	{
		logger.info("[START] testNameAddSuccess() ");
		assertNotNull("Name Added", oasController.AddName("Furniture"));
		logger.info("[END] testNameAddSuccess() ");
	}
	@Test
	public void testDescriptionAddSuccess() throws DescriptionIsBlankException
	{
		logger.info("[START] testDescriptionAddSuccess() ");
		assertNotNull("Name Added", oasController.AddDescription("It includes item such as chair,table,almirah,etc"));
		logger.info("[END] testDescriptionAddSuccess() ");
	}
	@Test(expected = NameIsBlankException.class)
	public void testNameAddFailed() throws NameIsBlankException {
		logger.info("[START] testNameAddFailed() ");
		oasController.AddName(null);
		logger.info("[END] testNameAddFailed()");
	}
	@Test(expected = DescriptionIsBlankException.class)
	public void testDescAddFailed() throws DescriptionIsBlankException {
		logger.info("[START]  testDescAddFailed()");
		oasController.AddDescription(null);
		logger.info("[END]  testDescAddFailed()");
	}
	
}
