package com.initcat.user_common.model.resp;

import com.initcat.user_common.model.dto.WalletTransRecordDTO;
import lombok.Data;

import java.util.List;

/**
 * 零钱交易明细
 *
 * @author libo
 * @package com.initcat.user_common.model.resp
 * @company xmiles
 * @date 2019/3/31
 */
@Data
public class WalletListTransRecordResp {
	List<WalletTransRecordDTO> transRecords;
}
