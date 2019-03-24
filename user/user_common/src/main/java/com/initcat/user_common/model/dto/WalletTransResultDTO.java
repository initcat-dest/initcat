package com.initcat.user_common.model.dto;

import com.initcat.user_common.model.enums.WalletTransResultEnum;
import lombok.Builder;
import lombok.Data;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.dto
 * @company xmiles
 * @date 2019/3/24
 */
@Data
@Builder
public class WalletTransResultDTO {

	/**
	 * 交易结果
	 */
	private WalletTransResultEnum transResult;
	/**
	 * 交易后账户信息
	 */
	private WalletAccountInfoDTO walletAccountInfo;
}
