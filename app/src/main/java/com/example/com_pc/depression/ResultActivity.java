package com.example.com_pc.depression;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ResultActivity extends AppCompatActivity {

final int count=0; //bdi 3번의 점수를 평균 낸 점수
    private GraphicalView mChartView;

    private String[] mMonth = new String[]{
            "1차", "2차", "3차"
    };
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        TextView tt1 = (TextView)findViewById(R.id.tt0);  //수정
        tt1.setText(intent.getStringExtra("Title"));
        // tt2.setText(intent.getStringExtra("date"));
        if(count<=9)
            tt1.setText("우울하지 않은 상태입니다.");
        else if(count>=10&&count<=15) {
            tt1.setText("가벼운 우울 상태입니다.");
        }
        else if(count>=16&&count<=23) {
            tt1.setText("가벼운 우울 상태입니다.");
        }
        else
            tt1.setText("심각한 우울 상태입니다."); // 여기까지 ! (마지막 BDI 진단 값을 받아서 출력해주어야해요!)
        drawChart();
    }


    private void drawChart() { // drawChart 함수는 모두 복사해서 붙여넣기 해주시면 될거 같아요~

        int[] x = {0, 1, 2};
        int[] income = {40, 20, 35};
        XYSeries incomeSeries = new XYSeries("");
        // Creating an XYSeries for Expense
        XYSeries expenseSeries = new XYSeries("");
        // Adding data to Income and Expense Series
        for (int i = 0; i < x.length; i++) {
            incomeSeries.add(i, income[i]);
        }
        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
        // Adding Expense Series to dataset
        dataset.addSeries(expenseSeries);

        // Creating XYSeriesRenderer to customize incomeSeries

        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(Color.rgb(233,150,122)); //color of the graph set to cyan
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(1);
        incomeRenderer.setDisplayChartValues(true);
        incomeRenderer.setDisplayChartValuesDistance(10); //setting chart value distance

        // Creating XYSeriesRenderer to customize expenseSeries

        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();

        expenseRenderer.setColor(Color.rgb(233,150,122));
        expenseRenderer.setFillPoints(true);
        expenseRenderer.setLineWidth(1);
        expenseRenderer.setDisplayChartValues(true);

        // Creating a XYMultipleSeriesRenderer to customize the whole chart

        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setXLabelsColor(Color.WHITE);
        multiRenderer.setChartTitle("우울증 진단 최종 결과");
        multiRenderer.setXTitle("");
        multiRenderer.setYTitle("");

        //setting text size of the title
        multiRenderer.setChartTitleTextSize(28);
        multiRenderer.setAxisTitleTextSize(24);
        //setting text size of the graph lable
        multiRenderer.setLabelsTextSize(24);


        //setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        //setting click false on graph
        multiRenderer.setClickEnabled(false);
        //setting lines to display on y axis
        multiRenderer.setShowGridY(false);
        //setting lines to display on x axis
        multiRenderer.setShowGridX(false);
        //setting legend to fit the screen size
        multiRenderer.setFitLegend(true);
        //setting displaying line on grid
        multiRenderer.setShowGrid(false);
        //setting displaying lines on graph to be formatted(like using graphics)
        multiRenderer.setAntialiasing(true);
        //setting to in scroll to false
        multiRenderer.setInScroll(false);
        multiRenderer.setZoomEnabled(false, false);
        multiRenderer.setZoomEnabled(false);
        multiRenderer.setExternalZoomEnabled(false);
        //setting to set legend height of the graph

        multiRenderer.setLegendHeight(30);

        //setting x axis label align

        multiRenderer.setXLabelsAlign(Paint.Align.CENTER);

        //setting y axis label to align

        multiRenderer.setYLabelsAlign(Paint.Align.LEFT);
        //setting text style
        multiRenderer.setTextTypeface("bold", Typeface.NORMAL);
        //setting no of values to display in y axis
        multiRenderer.setYLabels(10);
        multiRenderer.setXLabelsColor(Color.WHITE);
        multiRenderer.setYAxisMin(0);
        multiRenderer.setYAxisMax(63);
        //xaxiz에서. 5로 그래프를 오른쪽으로 이동하는 데 사용되는 설정
        multiRenderer.setXAxisMin(-0.7);
        // x축 갯수
        multiRenderer.setXAxisMax(2.5);
        // 막대 사이 공간
        multiRenderer.setBarSpacing(0.1);
        // multiRenderer.setBarWidth(2);

        // 그래프 배경색 투명하게
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(Color.rgb(233,150,122));

        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right

        multiRenderer.setMargins(new int[]{40, 10, 10, 10});
        for (int i = 0; i < x.length; i++) {
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }
        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(incomeRenderer);
        multiRenderer.addSeriesRenderer(expenseRenderer);
        //this part is used to display graph on the xml
        LinearLayout layout = (LinearLayout) findViewById(R.id.chart_bar);
        //remove any views before u paint the chart
        layout.removeAllViews();
        //drawing bar chart

        mChartView = ChartFactory.getBarChartView(this, dataset, multiRenderer, BarChart.Type.DEFAULT);
        layout.addView(mChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    }
}