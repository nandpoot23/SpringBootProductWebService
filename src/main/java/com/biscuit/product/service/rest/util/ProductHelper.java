package com.biscuit.product.service.rest.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Provides various product system helper methods.
 *
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class ProductHelper {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductHelper.class);

	private static final int NPA_LEN = 3;
	private static final int NXX_LEN = 3;

	/**
	 * Formats the five digit billing region, stripping off leading whitespace
	 * and left padding with zeroes, if necessary.
	 * 
	 * @param billingRegion
	 * 
	 * @return The formatted five digit billing region.
	 */
	public String formatGdpBillingRegion(String billingRegion) {
		return StringUtils.leftPad(StringUtils.strip(billingRegion), 5, '0');
	}

	/**
	 * Formats the five digit billing region, stripping off leading whitespace
	 * and left padding with zeroes, if necessary.
	 * 
	 * @param billingRegion
	 * 
	 * @return The formatted five digit billing region.
	 */
	public String formatGdpBillingRegion(Long billingRegion) {
		String ddpBr = null;
		if (billingRegion != null) {
			ddpBr = StringUtils.leftPad(
					StringUtils.strip(billingRegion.toString()), 5, '0');
		}
		return ddpBr;
	}

	/**
	 * Formats the two digit customer number, stripping off leading whitespace
	 * and left padding with zeroes, if necessary.
	 * 
	 * @param custNumber
	 * 
	 * @return The formatted two digit customer number.
	 */
	public String formatGdpCustNumber(String custNumber) {
		return StringUtils.leftPad(StringUtils.strip(custNumber), 2, '0');
	}

	/**
	 * Formats the six digit house number, stripping off leading whitespace and
	 * left padding with zeroes, if necessary.
	 * 
	 * @param houseNumber
	 * 
	 * @return The formatted six digit house number.
	 */
	public String formatGdpHouseNumber(String houseNumber) {
		return StringUtils.leftPad(StringUtils.strip(houseNumber), 6, '0');
	}

	/**
	 * Get billing region from the account number Logic: Account Number :
	 * AAAABBBBCCCCDDDD Billing Region : AAAABB00CCC0
	 * 
	 * @param accountNumber
	 * @return
	 */
	public String getGsgMarketFromAccountNumber(String accountNumber) {
		int csgAccountNumberLength = 16;
		int systemLength = 4;
		int principalStart = 4;
		int principalLength = 2;
		int agentStart = 6;
		int agentLength = 3;
		String principalSuffix = "00";
		String agentSuffix = "0";

		String market = null;
		if (StringUtils.isBlank(accountNumber)
				|| (accountNumber.length() != csgAccountNumberLength)) {
			return null;
		}

		String system = StringUtils.left(accountNumber, systemLength);
		String principal = StringUtils.mid(accountNumber, principalStart,
				principalLength) + principalSuffix;
		String agent = StringUtils.mid(accountNumber, agentStart, agentLength)
				+ agentSuffix;

		StringBuffer stringBuffer = new StringBuffer(3);
		stringBuffer.append(system);
		stringBuffer.append(principal);
		stringBuffer.append(agent);
		market = stringBuffer.toString();
		return market;
	}

	/**
	 * Gets the four digit prin number from business unit. This is the second
	 * four digits of the 12-digit business unit number.
	 * 
	 * @param businessUnit
	 *            The business unit.
	 * @return The four digit prin number.
	 */
	public String getGsgPrinFromBusinessUnit(String businessUnit) {
		String prin = null;
		prin = StringUtils.substring(businessUnit, 4, 8);
		return prin;
	}

	/**
	 * Gets the four digit routing number from the first four digits of the
	 * business unit.
	 * 
	 * @param businessUnit
	 *            The business unit.
	 * @return The four digit routing number.
	 */
	public String getGsgRoutingFromBusinessUnit(String businessUnit) {
		String routing = null;
		routing = StringUtils.substring(businessUnit, 0, 4);
		return routing;
	}

	/**
	 * Gets the five digit billing region from the thirteen digit account
	 * number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The five digit billing region.
	 */
	public String getGdpBillingRegionFromAccount(String accountNumber) {
		String br = null;
		br = this.formatGdpBillingRegion(StringUtils.substring(accountNumber,
				0, 5));
		return br;
	}

	/**
	 * Gets the five digit billing region from the thirteen digit account
	 * number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The five digit billing region.
	 */
	public Long getGdpBillingRegionFromAccountAsLong(String accountNumber) {
		String br = null;
		try {
			br = this.formatGdpBillingRegion(StringUtils.substring(
					accountNumber, 0, 5));
			return Long.parseLong(br);
		} catch (Exception e) {
			LOG.debug("Error while parsing Billing Region", e);
		}
		return null;
	}

	/**
	 * Gets the two digit customer number from the thirteen digit account
	 * number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The two digit customer number.
	 */
	public String getGdpCustNumFromAccount(String accountNumber) {
		String cn = null;
		cn = this.formatGdpCustNumber(StringUtils.right(accountNumber, 2));
		return cn;
	}

	/**
	 * Gets the two digit customer number from the thirteen digit account
	 * number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The two digit customer number.
	 */
	public Long getGdpCustNumFromAccountAsLong(String accountNumber) {
		String cn = null;
		try {
			cn = this.formatGdpCustNumber(StringUtils.right(accountNumber, 2));
			return Long.parseLong(cn);
		} catch (Exception e) {
			LOG.debug("Error while parsing Cust Num", e);
		}
		return null;
	}

	/**
	 * Gets the six digit house number from the thirteen digit account number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The six digit house number.
	 */
	public String getGdpHouseNumFromAccount(String accountNumber) {
		String hn = null;
		hn = this.formatGdpHouseNumber(StringUtils.substring(accountNumber, 5,
				accountNumber.length() - 2));
		return hn;
	}

	/**
	 * Gets the six digit house number from the thirteen digit account number.
	 * 
	 * @param accountNumber
	 * 
	 * @return The six digit house number.
	 */
	public Long getGdpHouseNumFromAccountAsLong(String accountNumber) {
		String hn = null;
		try {
			hn = this.formatGdpHouseNumber(StringUtils.substring(accountNumber,
					5, accountNumber.length() - 2));
			return Long.parseLong(hn);
		} catch (Exception e) {
			LOG.debug("Error while parsing House Num", e);
		}
		return null;
	}

	/**
	 * Checks whether a string is <code>null</code>, empty, or contains a single
	 * space.
	 * 
	 * @param str
	 *            The string to check.
	 * @return <code>true</code> if the string is <i>not</i> <code>null</code>,
	 *         empty, or contains a single space. Otherwise, <code>false</code>.
	 */
	public boolean isNotNull(String str) {
		return StringUtils.isNotBlank(str);
	}

	/**
	 * Checks whether a string is <code>null</code>, empty, or contains a single
	 * space.
	 * 
	 * @param str
	 *            The string to check.
	 * @return <code>true</code> if the string is <code>null</code>, empty, or
	 *         contains whitespace. Otherwise, <code>false</code>.
	 */
	public boolean isNull(String str) {
		return !isNotNull(str);
	}

	/**
	 * Nullsafe equals...
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean equalsString(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 != null && s2 == null) {
			return false;
		} else if (s1 == null && s2 != null) {
			return false;
		}
		if (s1 != null && s2 != null) {
			return s1.equals(s2);
		}
		return false;
	}

	public String tnToNpa(String tn) {
		String npa = null;
		if (tn.length() >= getNpaLen()) {
			npa = tn.substring(0, getNpaLen());
		}
		return npa;
	}

	public String tnToNxx(String tn) {
		String nxx = null;
		if (tn.length() >= getNpaLen() + getNxxLen()) {
			nxx = tn.substring(getNpaLen(), getNpaLen() + getNxxLen());
		}
		return nxx;
	}

	public static int getNpaLen() {
		return NPA_LEN;
	}

	/**
	 * @return the nxxLen
	 */
	public static int getNxxLen() {
		return NXX_LEN;
	}

	/**
	 * Returns a pretty-formatted date string in the format of
	 * "MM/dd/yyyy HH:mm:ss"
	 * 
	 * @param cal
	 * @return
	 */
	public String formatDate(Calendar cal) {
		String str = null;
		if (cal != null) {
			String pattern = "MM/dd/yyyy HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				str = format.format(cal.getTime());
			} catch (Exception e) {
				LOG.error(" Error Occured.", e);
			}
		}
		return str;
	}

	public static int compareUtility(Integer sortOrder1, Integer sortOrder2) {
		if (sortOrder1 != null && sortOrder2 != null)
			return sortOrder1.compareTo(sortOrder2);
		else if (sortOrder1 != null)
			return -1;
		else if (sortOrder2 != null)
			return 1;
		else
			return 0;
	}

	public boolean gpaInList(String[] spas, String spa) {
		return (ArrayUtils.contains(spas, spa)
				|| ArrayUtils.contains(spas, getGsgRoutingFromBusinessUnit(spa)
						+ getGsgPrinFromBusinessUnit(spa)) || ArrayUtils
					.contains(spas, getGsgRoutingFromBusinessUnit(spa)));

	}

	/**
	 * Returns whether a string consists of all numeric digits.
	 * 
	 * Note, this does not count Negative signs!
	 * 
	 * @param number
	 * @return
	 */
	public boolean isNumeric(String number) {
		if (number != null && number.matches("\\d+")) {
			return true;
		}
		return false;
	}

	/**
	 * Creates the sixteen digit unit address, stripping off leading whitespace
	 * and adding leading zeroes, if necessary.
	 *
	 * @param unitAddr
	 *            The unit address.
	 * @return The massaged unit address.
	 */
	public String createUnitAddress(String unitAddr) {

		String massagedUnitAddress = null;

		massagedUnitAddress = StringUtils.leftPad(StringUtils.strip(unitAddr),
				16, '0');

		return massagedUnitAddress;
	}

	/**
	 * Determines if a number can be converted to a Long class.
	 * 
	 * @param number
	 *            A number.
	 * @return True or false depending on if it can be parsed as a Long
	 */
	public boolean isLong(String number) {
		if (isNumeric(number)) {
			try {
				Long.parseLong(number);
			} catch (Exception e) {
				LOG.warn(" Error in isLong()" + e, e);
				return false;

			}

			return true;
		}

		return false;
	}

	/**
	 * Checks whether a string is positive long or not.
	 * 
	 * @param str
	 *            The string to check.
	 * @return <code>true</code> if the string is positive long Otherwise,
	 *         <code>false</code>.
	 */
	public boolean isPositveLongValue(String str) {
		boolean isValid = false;
		if (isLong(str)) {
			try {
				Long l = Long.parseLong(str);
				if (l > 0) {
					isValid = true;
				}
			} catch (Exception e) {
				LOG.warn(" Error in isLong()" + e, e);
			}
		}
		return isValid;
	}

}
