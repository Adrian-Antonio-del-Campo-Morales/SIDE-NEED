package knowledgeMoulding;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class contains the all the data about the “TransformationMaps” and the
 * one method necessary for their use.
 * 
 * @attribute mapsMap The map used to assigns the appropriate
 *            “TransformationMap” to each attribute of the project.
 * @attribute mapXY Each of the “TransformationMaps” used in the project. "X"
 *            represents the range of possible values. "Y" is the
 *            proportionality of the relation of that particular attribute.
 */
public class TransformationMapsManager {

	private static Map<String, Map<Integer, Integer>> mapsMap = new TreeMap<String, Map<Integer, Integer>>();
	private static Map<Integer, Integer> map8Inverse = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map8Direct = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map6Inverse = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map6Direct = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map5Direct = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map5Inverse = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map4Inverse = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map3Inverse = new TreeMap<Integer, Integer>();
	private static Map<Integer, Integer> map2Direct = new TreeMap<Integer, Integer>();

	/**
	 * Initializes the values of the “TransformationMaps”.
	 */
	public void initializeMaps() {

		map8Inverse.put(0, 0);
		map8Inverse.put(1, 2);
		map8Inverse.put(2, 2);
		map8Inverse.put(3, 1);
		map8Inverse.put(4, 0);
		map8Inverse.put(5, -1);
		map8Inverse.put(6, -2);
		map8Inverse.put(7, -2);

		map8Direct.put(0, 0);
		map8Direct.put(1, -2);
		map8Direct.put(2, -2);
		map8Direct.put(3, -1);
		map8Direct.put(4, 0);
		map8Direct.put(5, 1);
		map8Direct.put(6, 2);
		map8Direct.put(7, 2);

		map6Inverse.put(0, 0);
		map6Inverse.put(1, 2);
		map6Inverse.put(2, 1);
		map6Inverse.put(3, 0);
		map6Inverse.put(4, -1);
		map6Inverse.put(5, -2);

		map6Direct.put(0, 0);
		map6Direct.put(1, -2);
		map6Direct.put(2, -1);
		map6Direct.put(3, 0);
		map6Direct.put(4, 1);
		map6Direct.put(5, 2);

		map5Direct.put(0, 0);
		map5Direct.put(1, -2);
		map5Direct.put(2, -1);
		map5Direct.put(3, 1);
		map5Direct.put(4, 2);

		map5Inverse.put(0, 0);
		map5Inverse.put(1, 2);
		map5Inverse.put(2, 1);
		map5Inverse.put(3, -1);
		map5Inverse.put(4, -2);

		map4Inverse.put(0, 0);
		map4Inverse.put(1, 2);
		map4Inverse.put(2, 0);
		map4Inverse.put(3, -2);

		map3Inverse.put(0, 0);
		map3Inverse.put(1, 2);
		map3Inverse.put(2, -2);

		map2Direct.put(0, -2);
		map2Direct.put(1, 2);

		mapsMap.put("ADAPTS1", map5Inverse);
		mapsMap.put("ADAPTS2", map5Inverse);
		mapsMap.put("ADAPTS4", map5Inverse);
		mapsMap.put("ADAPTS7", map5Inverse);
		mapsMap.put("ALPBTZ", map8Inverse);
		mapsMap.put("ARTICL1", map5Direct);
		mapsMap.put("ARTICL2", map5Direct);
		mapsMap.put("ARTICL3", map5Direct);
		mapsMap.put("ATTLVL1", map6Inverse);
		mapsMap.put("ATTLVL2", map6Inverse);
		mapsMap.put("ATTLVL4", map6Inverse);
		mapsMap.put("ATTLVL6", map6Inverse);
		mapsMap.put("BABSBK1", map8Direct);
		mapsMap.put("BABSBK2", map8Direct);
		mapsMap.put("BABSBK3", map8Direct);
		mapsMap.put("BEZDAC1", map8Direct);
		mapsMap.put("BEZDAC2", map8Direct);
		mapsMap.put("BEZDAC3", map8Direct);
		mapsMap.put("BEZDAC4", map6Direct);
		mapsMap.put("BEZDSL1", map8Direct);
		mapsMap.put("BEZDSL2", map8Direct);
		mapsMap.put("BEZDSL3", map8Direct);
		mapsMap.put("BEZDSL4", map6Direct);
		mapsMap.put("BEZWAT", map6Inverse);
		mapsMap.put("BFLWIN1", map8Inverse);
		mapsMap.put("BFLWIN2", map8Inverse);
		mapsMap.put("BFLWIN3", map8Inverse);
		mapsMap.put("BFLWIN5", map6Inverse);
		mapsMap.put("BGCCLR1", map8Direct);
		mapsMap.put("BGCCLR2", map8Direct);
		mapsMap.put("BGCCLR3", map8Direct);
		mapsMap.put("BHTTLK", map6Direct);
		mapsMap.put("BLNDWD1", map8Inverse);
		mapsMap.put("BLNDWD2", map8Inverse);
		mapsMap.put("BNOFIN1", map8Direct);
		mapsMap.put("BNOFIN2", map8Direct);
		mapsMap.put("BNOFIN3", map8Direct);
		mapsMap.put("BTRBST1", map8Direct);
		mapsMap.put("BTRBST2", map8Direct);
		mapsMap.put("BTRBST3", map8Direct);
		mapsMap.put("CMPSES1", map6Inverse);
		mapsMap.put("COMPSE", map8Inverse);
		mapsMap.put("COOPRT1", map5Inverse);
		mapsMap.put("COOPRT2", map5Inverse);
		mapsMap.put("COOPRT3", map5Inverse);
		mapsMap.put("CREATV1", map5Direct);
		mapsMap.put("CREATV2", map5Direct);
		mapsMap.put("CREATV3", map5Direct);
		mapsMap.put("DISORG1", map3Inverse);
		mapsMap.put("DISORG2", map3Inverse);
		mapsMap.put("DISORG3", map3Inverse);
		mapsMap.put("FLLDIR1", map5Inverse);
		mapsMap.put("FLLDIR2", map5Inverse);
		mapsMap.put("FLLDIR3", map5Inverse);
		mapsMap.put("GIFT1", map2Direct);
		mapsMap.put("GIFT2", map2Direct);
		mapsMap.put("GIFT3", map2Direct);
		mapsMap.put("KEEPS1", map5Inverse);
		mapsMap.put("KEEPS2", map5Inverse);
		mapsMap.put("KEEPS4", map5Inverse);
		mapsMap.put("KEEPS7", map5Inverse);
		mapsMap.put("LTLDO1", map6Direct);
		mapsMap.put("LTLDO2", map6Direct);
		mapsMap.put("LTLDO3", map6Direct);
		mapsMap.put("MBLWBMK1", map8Direct);
		mapsMap.put("MBLWBMK2", map8Direct);
		mapsMap.put("MDEFICT1", map8Direct);
		mapsMap.put("MDEFICT2", map8Direct);
		mapsMap.put("PERSIS1", map5Inverse);
		mapsMap.put("PERSIS2", map5Inverse);
		mapsMap.put("PERSIS5", map5Inverse);
		mapsMap.put("PERSIS7", map5Inverse);
		mapsMap.put("RCGNZE", map8Inverse);
		mapsMap.put("RTLAN1", map6Inverse);
		mapsMap.put("RTLAN2", map6Inverse);
		mapsMap.put("RTLAN3", map4Inverse);
		mapsMap.put("SENSTI", map6Inverse);
		mapsMap.put("SITSTI", map6Inverse);
		mapsMap.put("STOPLS", map5Direct);
		mapsMap.put("STUTER1", map3Inverse);
		mapsMap.put("STUTER2", map3Inverse);
		mapsMap.put("TLKLD1", map3Inverse);
		mapsMap.put("TLKLD2", map3Inverse);
		mapsMap.put("TLKLD3", map3Inverse);
		mapsMap.put("TLKSFT1", map3Inverse);
		mapsMap.put("TLKSFT2", map3Inverse);
		mapsMap.put("TLKSFT3", map3Inverse);

	}

	/**
	 * Transforms values using the “Transformation Maps”.
	 * 
	 * @exception Throws,
	 *                exception if the value being transformed is not present in
	 *                the “Transformation Maps”
	 * @param currentAttribute,
	 *            The attribute being transformed.
	 * @param originalValue,
	 *            The original value of the attribute being transformed.
	 * @return The transformed value.
	 */
	public String mapValue(String currentAttribute, String originalValue) {
		try {
			return mapsMap.get(currentAttribute).get(Integer.valueOf(originalValue)).toString();
		} catch (Exception e) {
			System.out.println("MAPPING_ERROR");
			e.printStackTrace();
			return "MAPPING_ERROR";
		}

	}
}
