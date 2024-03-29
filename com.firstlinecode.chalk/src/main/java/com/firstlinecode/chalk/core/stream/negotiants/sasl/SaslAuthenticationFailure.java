package com.firstlinecode.chalk.core.stream.negotiants.sasl;

import com.firstlinecode.basalt.protocol.core.stream.sasl.Failure;
import com.firstlinecode.chalk.core.stream.IAuthenticationFailure;
import com.firstlinecode.chalk.core.stream.IAuthenticationToken;

public class SaslAuthenticationFailure implements IAuthenticationFailure {
	
	private SaslNegotiant sasl;
	private Failure.ErrorCondition errorCondition;
	private boolean retriable;
	private int count;
	
	public SaslAuthenticationFailure(SaslNegotiant sasl, Failure.ErrorCondition errorCondition, boolean retriable, int count) {
		this.sasl = sasl;
		this.errorCondition = errorCondition;
		this.retriable = retriable;
		this.count = count;
	}
	
	@Override
	public boolean isRetriable() {
		return retriable;
	}
	
	@Override
	public Failure.ErrorCondition getErrorCondition() {
		return errorCondition;
	}
	
	@Override
	public int getFailureCount() {
		return count;
	}
	
	@Override
	public void retry(IAuthenticationToken authToken) {
		if (!retriable) {
			throw new IllegalStateException("Authenticate failure isn't retriable.");
		}
		
		sasl.retry(authToken);
	}
	
	@Override
	public void abort() {
		if (!retriable) {
			return;
		}
		
		sasl.abort();
	}
}
