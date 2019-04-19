package com.initcat.user_common.model.resp;

import com.initcat.user_common.dto.CoinTransRecordDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoinListTransRecordResp {
    List<CoinTransRecordDTO> transRecords;
}
