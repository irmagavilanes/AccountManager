package com.att.data.account.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.att.data.account.entity.MovimientoEntity;
import com.att.data.account.vo.MovimientoVO;

@Repository
public class MovimientoRepository extends QueryDslBaseRepository<MovimientoEntity>{

	public MovimientoRepository() {
		super(MovimientoEntity.class);
	}

	public void guardarMovimiento(MovimientoVO movimientoVO) {
		MovimientoEntity movimientoEntity = new MovimientoEntity();
		movimientoEntity.setFecha(new Date());
		movimientoEntity.setTipoMovimiento(movimientoVO.getTipoMovimiento());
		movimientoEntity.setValor(movimientoVO.getValor());
		movimientoEntity.setSaldo(movimientoVO.getSaldo());
		save(movimientoEntity);
	}
	
	public void editarMovimiento() {
		
	}
}
