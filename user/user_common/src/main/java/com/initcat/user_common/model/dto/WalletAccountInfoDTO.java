package com.initcat.user_common.model.dto;

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
public class WalletAccountInfoDTO {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 零钱余额
	 */
	private Integer walletBalance;

}
