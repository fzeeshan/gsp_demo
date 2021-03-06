
package demos.dlineage.dataflow.listener;

import java.io.File;

public interface DataFlowHandleListener
{

	public void startAnalyze( File file, long lengthOrCount, boolean isCount );

	public void startParse( File file, long length, int index );

	public void endParse( );

	public void startAnalyzeDataFlow( int totalCount );

	public void startAnalyzeStatment( int index );

	public void endAnalyzeStatment( int index );

	public void endAnalyzeDataFlow( );

	public void startOutputDataFlowXML( );

	public void endOutputDataFlowXML( long length );

	public void endAnalyze( );

	public boolean isCanceled( );

}
