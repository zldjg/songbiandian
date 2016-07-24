package songbiandian.dao;

/**
 * 由于项目中要求对输入值进行检查，故定义此接口用于对试验结果的合理性进行检查
 * @author TerenceWu
 *
 */
public interface ValidateTestResult {
	boolean validateTestResult();
}
