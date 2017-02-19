******************************
* JFREECHART: Version 0.9.14 *
******************************

17 November 2003

(C)opyright 2000-2003, by Object Refinery Limited and Contributors.

Written by David Gilbert and others.

-----------------
1.  INTRODUCTION
-----------------
JFreeChart is a free Java class library for producing charts.
It runs on the Java 2 Platform (JDK 1.2.2 or later) and uses the Java
2D API for drawing.

JFreeChart is licensed under the terms of the GNU Lesser General
Public Licence (LGPL).  A copy of the licence is included in the
download.

Please note that JFreeChart is distributed WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.  Please refer to the licence for details.

SPECIAL NOTE: THE JFREECHART API IS NOT YET STABLE.  IT IS SUBJECT TO
CHANGE UNTIL VERSION 1.0.0 IS RELEASED.

-------------------
2.  LATEST VERSION
-------------------
The latest version of this class library can be obtained from:

    http://www.jfree.org/jfreechart/index.html

If you have an comments, suggestions or bugs to report, please post a
message in the JFreeChart forum.

------------------------------
3.  DOCUMENTATION AND SUPPORT
------------------------------
You can download installation instructions
(jfreechart-0.9.14-install.pdf) from the JFreeChart home
page or the project page on SourceForge.

Commercial support and documentation for JFreeChart is provided by Object
Refinery Limited, a company owned and operated by David Gilbert (the original
author of JFreeChart).  For more information, please see:

http://www.object-refinery.com/jfreechart/support.html

Javadoc HTML files are available on-line.  If you wish to keep a local
copy of the Javadoc files, you can regenerate the Javadocs directly
from the source code.  You can do this using the 'javadoc' utility
directly, or with the Ant script (build.xml) included in the
distribution.

-----------------
4.  DEPENDENCIES
-----------------
JFreeChart has the following dependencies:

(a)  JDK 1.2.2 or higher - JFreeChart requires the Java2D and Collections
APIs, so it won't work with JDK 1.1.  If you are using JFreeChart to create
applets, this means that you cannot rely on the JVM integrated with
Microsoft's Internet Explorer - your users will need to have the Java 2
plug-in installed.  Most other browsers (e.g. Mozilla/Netscape, Galeon,
Konqueror) support JDK 1.4.

(b)  JCommon - version 0.8.9 or later.  The runtime jar file is
included in the JFreeChart distribution.  You can obtain the complete
source code for JCommon from:

    http://www.jfree.org/jcommon/index.html

JCommon is licensed under the terms of the GNU Lesser General Public Licence.

(c)  GNU JAXP - a free implementation of the standard XML processing
APIs for Java.

    http://www.gnu.org/software/classpathx/jaxp/

Classes in the org.jfree.data.xml package require this library, or
another JAXP v1.1 compliant parser.  The gnujaxp.jar file (from the
gnujaxp-1.0beta1.zip distribution) is included with JFreeChart.  GNU
JAXP is licensed under the terms of the GNU General Public License
with an additional library exception.

(d)  servlet.jar - NOT INCLUDED IN THE DISTRIBUTION.  You need to
obtain a copy of this file (I used the one in the Tomcat 4.1.18
distribution) and put it in the 'lib' directory if you want to
recompile JFreeChart.  Classes in the org.jfree.chart.servlet
package require this file. 

(e)  JUnit - a unit testing framework (the junit.jar runtime file is
included in the distribution).  JUnit is licensed under the terms
of the IBM Common Public License.  You can find out more about JUnit
and/or download the latest version from:

    http://www.junit.org

The JUnit tests included with JFreeChart have been created using JUnit
3.8.

--------------------
5.  ANT BUILD SCRIPT
--------------------
An Ant build script (build.xml) is included in the distribution.  This
is the same script that is used to create the JFreeChart distribution.

For more information about Ant:

    http://ant.apache.org/

Please note that you will need to obtain the servlet.jar file (see the
DEPENDENCIES section above) before running the Ant script.

------------------------
6.  THE DEMO APPLICATION
------------------------
The main demonstration application is called JFreeChartDemo.  To run
it you need the files jcommon-0.8.9.jar, jfreechart-0.9.14.jar and
jfreechart-0.9.14-demo.jar.

Using JDK 1.2.2 (or later) you can start the demo by running the class:

    org.jfree.chart.demo.JFreeChartDemo.

Use the following command:

    java -jar jfreechart-0.9.14-demo.jar

Alternatively, you can specify the class and classpath via the command
line. For example, on Linux, the following command line will run the demo
application:

java -classpath lib/jcommon-0.8.9.jar:jfreechart-0.9.14.jar:jfreechart-0.9.14-demo.jar org.jfree.chart.demo.JFreeChartDemo

Depending on your system configuration and the current working
directory, you may need to specify paths in the above command line.

If you are using Windows, please note that the entries on the class
path should be separated with a semi-colon rather than a colon:

java -classpath lib/jcommon-0.8.9.jar;jfreechart-0.9.14.jar;jfreechart-0.9.14-demo.jar org.jfree.chart.demo.JFreeChartDemo

There are also more than 100 other demonstration applications included
in the download:

org.jfree.chart.demo.AreaChartDemo
org.jfree.chart.demo.BarChartDemo1
org.jfree.chart.demo.BarChartDemo2
org.jfree.chart.demo.BarChartDemo3
org.jfree.chart.demo.BarChart3DDemo1
org.jfree.chart.demo.BarChart3DDemo2
org.jfree.chart.demo.BoxAndWhiskerDemo
org.jfree.chart.demo.BubblePlotDemo
org.jfree.chart.demo.BubblyBubblesDemo
org.jfree.chart.demo.BubblyBubblesDemo2
org.jfree.chart.demo.CandlestickDemo
org.jfree.chart.demo.CombinedCategoryPlotDemo1
org.jfree.chart.demo.CombinedCategoryPlotDemo2
org.jfree.chart.demo.CombinedXYPlotDemo1
org.jfree.chart.demo.CombinedXYPlotDemo2
org.jfree.chart.demo.CombinedXYPlotDemo3
org.jfree.chart.demo.CombinedXYPlotDemo4
org.jfree.chart.demo.CompassDemo
org.jfree.chart.demo.CompassDemo2
org.jfree.chart.demo.ContourPlotDemo
org.jfree.chart.demo.ContourPlotDemo2
org.jfree.chart.demo.DifferenceChartDemo
org.jfree.chart.demo.DualAxisDemo
org.jfree.chart.demo.DualAxisDemo2
org.jfree.chart.demo.DualAxisDemo3
org.jfree.chart.demo.DualAxisDemo4
org.jfree.chart.demo.DynamicDataDemo
org.jfree.chart.demo.EventFrequencyDemo
org.jfree.chart.demo.FastScatterPlotDemo
org.jfree.chart.demo.GanttDemo1
org.jfree.chart.demo.GanttDemo2
org.jfree.chart.demo.HighLowChartDemo
org.jfree.chart.demo.ImageMapDemo1
org.jfree.chart.demo.ImageMapDemo2
org.jfree.chart.demo.ImageMapDemo3
org.jfree.chart.demo.InternalFrameDemo
org.jfree.chart.demo.IntervalBarChartDemo1
org.jfree.chart.demo.LineChartDemo1
org.jfree.chart.demo.LineChartDemo2
org.jfree.chart.demo.LineChartDemo3
org.jfree.chart.demo.LineChartDemo4
org.jfree.chart.demo.LineChartDemo5
org.jfree.chart.demo.MarkerDemo1
org.jfree.chart.demo.MeterPlotDemo
org.jfree.chart.demo.MinMaxCategoryPlotDemo
org.jfree.chart.demo.MouseZoomDemo
org.jfree.chart.demo.MovingAverageDemo
org.jfree.chart.demo.MultiPieChartDemo
org.jfree.chart.demo.MultiPieChartDemo2
org.jfree.chart.demo.MultipleAxisDemo1
org.jfree.chart.demo.MultipleAxisDemo2
org.jfree.chart.demo.OverlaidBarChartDemo
org.jfree.chart.demo.OverlaidCategoryChartDemo
org.jfree.chart.demo.OverlaidXYPlotDemo
org.jfree.chart.demo.OverlaidXYPlotDemo2
org.jfree.chart.demo.ParetoChangeDemo
org.jfree.chart.demo.Pie3DChartDemo1
org.jfree.chart.demo.Pie3DChartDemo2
org.jfree.chart.demo.PieChartDemo1
org.jfree.chart.demo.PieChartDemo2
org.jfree.chart.demo.PieChartDemo3
org.jfree.chart.demo.PieChartDemo4
org.jfree.chart.demo.PopulationChartDemo
org.jfree.chart.demo.PriceVolumeDemo
org.jfree.chart.demo.ScatterPlotDemo
org.jfree.chart.demo.ScatterPlotDemo2
org.jfree.chart.demo.ScatterPlotDemo3
org.jfree.chart.demo.ScatterPlotDemo4
org.jfree.chart.demo.SegmentedHighLowChartDemo
org.jfree.chart.demo.StackedAreaChartDemo
org.jfree.chart.demo.StackedAreaXYChartDemo
org.jfree.chart.demo.StackedBarChart3DDemo
org.jfree.chart.demo.StackedBarChartDemo1
org.jfree.chart.demo.StackedBarChartDemo2
org.jfree.chart.demo.StatisticalBarChartDemo
org.jfree.chart.demo.SurveyResultsDemo
org.jfree.chart.demo.SurveyResultsDemo2
org.jfree.chart.demo.SurveyResultsDemo3
org.jfree.chart.demo.SymbolicChartDemo1
org.jfree.chart.demo.SymbolicXYPlotDemo
org.jfree.chart.demo.SymbolicYPlotDemo
org.jfree.chart.demo.ThermometerDemo
org.jfree.chart.demo.ThermometerDemo2
org.jfree.chart.demo.TimePeriodValuesDemo
org.jfree.chart.demo.TimePeriodValuesDemo2
org.jfree.chart.demo.TimeSeriesDemo
org.jfree.chart.demo.TimeSeriesDemo2
org.jfree.chart.demo.TimeSeriesDemo3
org.jfree.chart.demo.TimeSeriesDemo4
org.jfree.chart.demo.TimeSeriesDemo5
org.jfree.chart.demo.TimeSeriesDemo6
org.jfree.chart.demo.TimeSeriesDemo7
org.jfree.chart.demo.TimeSeriesDemo8
org.jfree.chart.demo.TimeSeriesDemo9
org.jfree.chart.demo.TimeSeriesDemo10
org.jfree.chart.demo.WaterTemperatureDemo
org.jfree.chart.demo.WindChartDemo
org.jfree.chart.demo.XYAreaChartDemo
org.jfree.chart.demo.XYAreaChartDemo2
org.jfree.chart.demo.XYLogAxesDemo
org.jfree.chart.demo.XYStepChartDemo
org.jfree.chart.demo.YIntervalChartDemo

You can run these applications in the same way as the JFreeChartDemo
class described above.

---------------
7.  WHAT's NEW
---------------
A list of changes in recent versions:

0.9.14 : (17-Nov-2003) 
         - implemented zooming for the FastScatterPlot class;
         - added item label support for stacked bar charts, and new fall back
	 options for item labels that don't fit within bars;
         - modified the CategoryAxis class to allow additional options for the
	 alignment and rotation of category labels;
         - addition of the AxisState class, used in the drawing of axes to
	 eliminate a bug when multiple threads draw the same axis
	 simultaneously;
         - provided additional attributes in the DateTickUnit class to improve
	 labelling on a segmented DateAxis;
         - added support for GradientPaint in bar charts;
         - updated the PNGEncoder;
         - fixes for tick label positioning on axes;
         - various Javadoc updates;
         - numerous bug fixes;

0.9.13 : (26-Sep-2003)
         - various enhancements to the stacked area XY charts;
         - added a completion indicator for the Gantt chart;
         - range and domain markers can now be placed in the foreground or the
	   background;
         - more fixes for cloning and serialization;
         - fixed mouse event bug for combined charts;
         - fixed bugs in the PngEncoder class;
         - incorporated .properties files that were missing from the 0.9.12
           distribution;

0.9.12 : (11-Sep-2003)
         - extended box-and-whisker plots to work with the CategoryPlot	class
	   as well as the XYPlot class (based on work by David Browning);
         - added a new LayeredBarRenderer (by Arnaud Lelievre);
         - added support for stacked area charts with the XYPlot class (thanks
	   to Richard Atkinson);
         - improved HTML image map support (thanks to Richard Atkinson);
         - added localized resources for the chart property editors (thanks to
	   Arnaud Lelievre).  Current translations include French and Portugese
	   (thanks to Eduardo Ramalho);
         - added facility for setting all rendering hints;
         - improved support for cloning and serialization;
         - fixed a bug in the XYSeries class that prevented the TableXYDataset
	   from functioning correctly;
         - improved date axis labelling with segmented time lines;
         - fixed several bugs in the secondary dataset/axis/renderer code;
         - fixed bugs in the JDBCCategoryDataset class;
         - numerous other bug fixes;

0.9.11 : (8-Aug-2003)
         - added support for box-and-whisker plots, thanks to David Browning;
         - lots of bug fixes;

API changes in this release are minimal and have been implemented using
deprecation, so code written against 0.9.10 should recompile.

0.9.10 : (25-Jul-2003) 
         - added support for multiple secondary axes, datasets and
           renderers;
         - minor feature enhancements and bug fixes;

0.9.9 : (10-Jul-2003) PLEASE NOTE THAT MAJOR CHANGES HAVE BEEN MADE IN THIS
RELEASE AND ONE OR TWO FEATURES MAY BE BROKEN.  PLEASE REPORT BUGS SO THEY CAN
BE FIXED FOR THE NEXT RELEASE.

        - merged the HorizontalCategoryPlot and VerticalCategoryPlot classes,
	  into the CategoryPlot class;
        - merged the horizontal and vertical axis classes;
        - merged the horizontal and vertical renderer classes;
        - CategoryPlot and XYPlot now support both horizontal and vertical
	  orientation via the setOrientation(...) method;
        - merged horizontal and vertical methods in the ChartFactory class;
        - created new combined plot classes: CombinedDomainCategoryPlot,
	  CombinedRangeCategoryPlot, CombinedDomainXYPlot and
	  CombinedRangeXYPlot (these can all be drawn with a horizontal or
	  vertical orientation);
        - Bill Kelemen has enhanced the DateAxis class to handle segmented
	  timelines.  This can be used, for example, to skip weekends for
	  daily stock price charts;
        - Richard Atkinson has updated the ServletUtilities class;
        - Bryan Scott has added an XYDatasetTableModel class for presenting
	  datasets in a JTable;
        - modified XYPlot to allow renderers to use multiple passes through
	  the dataset;
        - added new XYDifferenceRenderer;
        - added support for colored bands between gridlines in XYPlot;
        - added new XYDrawableAnnotation class;
        - added a new attribute to control the order of dataset rendering in 
          a CategoryPlot;
        - extended the value label mechanism for the renderers, to allow
	  better (per series) control over label generation, positioning and
	  visibility;
        - CategoryItemTooltipGenerator has been renamed
	  CategoryItemLabelGenerator, since it is now being used to generated
	  item labels as well as tooltips;
        - there is now support for horizontal stacked 3D bar charts;
        - added support for range markers against secondary axis in a 
          CategoryPlot;
        - added labels to domain and range markers;
        - added a new HistogramDataset class (contributed by Jelai Wang) to
	  make it easier to create histograms with JFreeChart;
        - moved the DrawingSupplier into the plot class, renderers now
	  reference the supplier from the plot (parent plot for combined and
	  overlaid charts).  This means that renderers now share a single
	  DrawingSupplier by default, which simplifies the creation of
	  combined charts;
        - changed the ColorBarAxis classes that extended the NumberAxis class,
	  to a single ColorBar class that wraps a ValueAxis (may have broken
	  one or two things in the process);
        - Barak Naveh has contributed new classes MatrixSeries and
	  MatrixSeriesCollection, along with demos:  BubblyBubblesDemo.java
	  and BubblyBubblesDemo2.java;
        - the TextTitle class now has a background paint attribute;
        - the StandardLegend class now generates LegendEntity objects if a
	  ChartRenderingInfo instance is supplied to the draw(...) method;
        - extended the CategoryTextAnnotation class to take into account a
	  category anchor point.  See the SurveyResultsDemo.java application
	  for an example;
        - included numerous bug fixes;

0.9.8 : (24-Apr-2003)
        - changed package naming from com.jrefinery.* to org.jfree.*;
        - added new TimePeriodValuesCollection class;
        - added MIME type code to ServletUtilities class;
        - reversed the order of PieDataset and KeyedValuesDataset in 
          the class hierarchy;
        - reversed the order of CategoryDataset and KeyedValues2DDataset
          in the class hierarchy;
        - minor bug fixes;

0.9.7 : (11-Apr-2003) 
        - added a new ValueDataset interface and DefaultValueDataset
          class, and changed the CompassPlot class to use this instead
	  of MeterDataset;
        - added DataUtilities class, to support creation of Pareto
          charts (new demo included);
        - updated writeImageMap method as suggested by Xavier Poinsard
          (see Feature Request 688079);
        - implemented Serializable for most classes (this is likely to
          require further testing);
        - incorporated contour plot updates from David M. O'Donnell;
        - added new CategoryTextAnnotation and XYLineAnnotation
          classes;
        - added new HorizontalCategoryAxis3D class contributed by
          Klaus Rheinwald;

        Bug fixes:
        - added a workaround for JVM crash (a JDK bug) in pie charts
          with small sections (see bug report 620031);
        - fixed minor bug in HorizontalCategoryPlot constructor (see
          bug report 702248);
        - added code to ensure HorizontalNumberAxis3D is not drawn if
          it is not visible (see bug report 702466);
        - added small fix for suppressed chart change events (see bug
          report 690865);
        - added pieIndex parameter to tooltip and URL generators for
          pie charts;
        - fixed bug in getLastMillisecond() method for the Second
          class and the getFirstMillisecond() method for the Year
          class (picked up in JUnit tests);
        - in TextTitle, changed width used for relative spacing to fix
          bug 703050;

0.9.6 : (17-Feb-2003) Bug fixes:
        - fixed null pointer exception in DefaultCategoryDataset;
        - fixed update problem for PaintTable, StrokeTable and
	  ShapeTable objects;
        - added methods to control colors in PiePlot (these were
	  inadvertantly removed in the changes made for 0.9.5);
        - fixed auto-range update problem for secondary axis;
        - fixed missing category labels in the overlaid category plot;
        - fixed constructors for symbolic axes;
        - corrected error in Javadoc generation (Ant script);

0.9.5 : (6-Feb-2003)  PLEASE NOTE THAT MAJOR CHANGES TO THE
        JFREECHART API HAVE BEEN MADE IN THIS RELEASE!

        - added support for secondary axes, datasets and renderers;
        - added new data interfaces (Value, Values, Values2D,
          KeyedValues and KeyedValues2D) and incorporated these into
          the existing PieDataset and CategoryDataset interfaces.
        - modified the CategoryDataset interface to be more
          symmetrical, data is organised in rows and columns (as
          before) but can now be accessed by row/column index or
          row/column key.   
        - added support for reading PieDatasets and CategoryDatasets
          from XML files.
        - created separate packages for the axes
          (com.jrefinery.chart.axis), plots (com.jrefinery.chart.plot)
          and renderers (com.jrefinery.chart.renderer).
        - series attributes (paint, outline paint, stroke and shape)
          are now controlled by the renderer classes using lookup
          tables.  Introduced the DrawingSupplier interface (and
          DefaultDrawingSupplier class) which is used to populate the
          lookup tables from a common source (necessary to coordinate
          complex combined charts).
        - the chart legend can now display shapes corresponding to
          series. 
        - moved responsibility for category distribution to the
          CategoryAxis class, which tidies up the code in the
          CategoryPlot classes.  
        - gridlines are now controlled by the CategoryPlot and XYPlot
          classes, not the axes (included in this change is the
          addition of gridlines for the CategoryPlot domain values).
        - changed the list of titles in the JFreeChart class to a
          title and a list of subtitles.  
        - added new renderers for XYPlot (XYBubbleRenderer and
          YIntervalRenderer).
        - modified Gantt chart to display sub-tasks.
        - added ContourPlot class (still experimental) by David
          M. O'Donnell.
        - introduced new MovingAverage class.
        - ChartMouseEvent now includes source chart.
        - numerous bug fixes.
        - lots of Javadoc updates.

0.9.4 : (18-Oct-2002)  Added a new stacked area chart (contributed by Dan
        Rivett) and a compass plot (contributed by Bryan Scott).  Updated
        the ThermometerPlot class. Added a new XYDotRenderer for scatter
        plots. Modified combined and overlaid plots to use the series colors
        specified in the sub plot rather than the parent plot (this makes it
        easier to align the colors in the legend).  Added Regression class
        for linear and power regressions.  BasicTimeSeries can now
        automatically drop "old" data.  Some clean-up work in the code for
        tooltips and the event listener mechanism.  Richard Atkinson has
        incorporated some useful extensions for servlets/JSP developers.

        Ran Checkstyle and corrected issues reported for most classes.
        Checkstyle is a free utility that you can download from:

            http://checkstyle.sourceforge.net

        Fixed bugs and updated documentation.

        API changes include:
        - added tickMarkPaint to Axis constructor (also affects
          subclasses);
        - added getLegendItems() to Plot, and deprecated
          getLegendItemLabels();
        - added getLegendItem(int) to XYItemRenderer and
          CategoryItemRenderer.
        - most 'protected' member variables have been changed to
          'private'.

0.9.3 : (4-Sep-2002) Added multiple pie charts based on
        CategoryDataset.  Updated logarithmic axes.  Improved URL
        support for image map generation. Moved the com.jrefinery.data
        package from JCommon to JFreeChart. Added simple framework for
        chart annotations. Improved control over renderers. Duplicate
        x-values now allowed in XYSeries. Optional category label
        skipping in category axes. Added CategoriesPaint attribute to
        AbstractCategoryItemRenderer.  Added new attributes to
        MeterPlot class. Updated 3D pie chart to observe start angle
        and direction, and also foreground alpha < 1.0. Improved
        Javadoc comments. New demo applications, including:
        AnnotationDemo1, EventFrequencyDemo, JDBCCategoryChartDemo,
        JDBCPieChartDemo, JDBCXYChartDemo and MinMaxCategoryPlotDemo.
        Bug fixes:
        - negative percentages on PiePlot.
        - added listener notification to setXXXAxis(...) methods.
        - fixed DomainInfo method name clash.
        - added DomainIsPointsInTime flag to TimeSeriesCollection to
          give better control over auto range on axis for time series
          charts.
        - axis margins for date axes are no longer hard-coded.
        - fix for ordering of categories in JdbcCategoryDataset.
        - added check for null axis in mouse click handler.

        The CVS repository at SourceForge has also been restructured
        to match the distribution directory layout.

0.9.2 : (28-Jun-2002) PiePlot now has startAngle and direction
        attributes.  Added support for image map generation.  Added a
        new Pie3DPlot class. Added label drawing code to bar
        renderers. Added optional range markers to horizontal number
        axis.  Added bar clipping to avoid PRExceptions in bar
        charts.  JFreeChartDemo has been modified and now includes
        examples of the dial and thermometer plots.
        Bug fixes:
        - auto range for VerticalNumberAxis when zero is forced to be
          included in the range.
        - fixed null pointer exception in StackedVerticalBarRenderer3D;
        - Added get/set methods for min/max chart drawing dimensions
          in ChartPanel;
        - HorizontalIntervalBarRenderer now handles single category;
        - verticalTickLabels now possible in HorizontalNumberAxis3D;
        - removed unnecessary imports;

0.9.1 : (14-Jun-2002) Bug fixes and Javadoc updates.
        - fixed auto range calculation for category plots;
        - fixed event notification for XYPlot;
        - fixed auto axis range for Gantt charts;
        - check for null popup menu in ChartPanel.mouseDragged;
        - new checks for null info in renderers;
        - range markers now drawn only if in visible axis range;

0.9.0 : (7-Jun-2002) New plots including an area chart, a horizontal
        3D bar chart, a Gantt chart and a thermometer chart.
        Combination plots have been reworked to provide a
        simpler framework, and extends to allow category plots to be
        combined. There is now a facility to add a ChartMouseListener
        to the ChartPanel (formerly JFreeChartPanel).  An interactive
        zooming feature (experimental at this point) is now available
        for XYPlots.  A new Polish translation has been added. Several
        fixes have been applied to the default tool tip generators.  A
        workaround has been added to fix the alignment between time
        series charts and the date axis.  There are some improvements
        to the VerticalLogarithmicAxis class, and now a corresponding
        HorizontalLogarithmicAxis class.  Additional demonstration
        applications have been added.  Fixed the popup menu bug.

0.8.1 : (5-Apr-2002) Localised resource bundles for French, German and
        Spanish languages (thanks to Anthony Boulestreau, Thomas Meier
        and Hans-Jurgen Greiner for the translations).  An area XY
        plot and meter chart contributed by Hari.  Symbol charts
        contributed by Anthony Boulestreau. An improved
        CandleStickRenderer class from Sylvain Vieujot.  Updated
        servlet code from Bryan Scott.  XYItemRenderers now have a
        change listener mechanism and therefore do not have to be
        immutable.  Additional demonstration applications for
        individual chart types. Minor bug fixes.

0.8.0 : (22-Mar-2002) All the category plots are now controlled
        through the one class (CategoryPlot) with plug-in renderers.
        Added a ResourceBundle for user interface items that require
        localisation. Added a logarithmic axis class contributed by
        Mike Duffy and some new JDBC and servlet code contributed by
        Bryan Scott.  Updated the JCommon class library to improve
        handling of time periods in different time zones.

0.7.4 : (6-Mar-2002) Bug fixes in the JCommon Class Library. Various
        Javadoc comment updates.  Some minor changes to the
        code. Added new domain name (http://www.object-refinery.com)
        in the source headers.

0.7.3 : (14-Feb-2002) Bug fixes.

0.7.2 : (8-Feb-2002) Integrated the WindPlot code from Achilleus
        Mantzios. Added an optional background image for the
        JFreeChart class, and another optional background image for
        the Plot class.  Added alpha-transparency for the plot
        foreground and background.  Added new pie chart label types
        that show values.  Fixed a bug with the legend that results in
        a loop at small chart sizes. Added some tooltip methods that
        were missing from the previous version. Changed the Insets
        class on chart titles to a new Spacer class that will allow
        for relative or absolute insets (the plan is to eventually
        replace all Insets in the JFreeChart classes).  Fixed a bug in
        the setAutoRangeIncludesZero method of the NumberAxis class.
        Added the instructions that were missing from the copies of
        the GNU Lesser General Public Licence included with JFreeChart.

0.7.1 : (25-Jan-2002) Added tooltips, crosshairs and zooming
        functions, thanks to Jonathan Nash and Hans-Jurgen Greiner
        for contributing the code that these features are based on.
        Moved the combination charts into the package
        com.jrefinery.chart.combination, made a number of other small
        API changes and fixed some bugs.  Removed the Javadoc HTML
        from the download to save space (you can regenerate it from
        the source code if you need it).

0.7.0 : (11-Dec-2001) New combination plots developed by Bill
        Kelemen.  Added Wolfgang Irler's servlet demo to the standard
        download.  The About window in the demo application now
        includes a list of developers that have contributed to the
        project.

0.6.0 : (27-Nov-2001) New plots including scatter plot, stacked bar
        charts and 3D bar charts.  Improved pie chart.  Data
        interfaces and classes moved to the JCommon class library.
        New properties to control spacing on bar charts.  New
        auto-tick mechanism.  JFreeChartPanel now incorporates
        buffering, and popup menu.  Javadocs revised.  Fixed numerous
        bugs from version 0.5.6.  Demo application updated.

----------------
8.  CONTRIBUTORS
----------------
JFreeChart wouldn't be half the library that it is today without the
contributions that have been made by the developers listed below:

    - Richard Atkinson
    - David Berry
    - Anthony Boulestreau
    - Jeremy Bowman
    - Nicolas Brodu
    - David Browning
    - S�ren Caspersen
    - Chuanhao Chiu
    - Pascal Collet
    - Martin Cordova
    - Paolo Cova
    - Mike Duffy
    - Jonathan Gabbai
    - Serge V. Grachov
    - Joao Guilherme Del Valle
    - Hans-Jurgen Greiner
    - Aiman Han
    - Jon Iles
    - Wolfgang Irler
    - Xun Kang
    - Bill Kelemen
    - Norbert Kiesel
    - Gideon Krause
    - Arnaud Lelievre
    - David Li
    - Tin Luu
    - Craig MacFarlane
    - Achilleus Mantzios
    - Thomas Meier
    - Jim Moore
    - Jonathan Nash
    - David M. O'Donnell
    - Krzysztof Paz
    - Tomer Peretz
    - Andrzej Porebski
    - Viktor Rajewski
    - Michael Rauch
    - Eduardo Ramalho
    - Cameron Riley
    - Dan Rivett
    - Thierry Saura
    - Andreas Schneider
    - Jean-Luc SCHWAB
    - Bryan Scott
    - Roger Studner
    - Irv Thomae
    - Eric Thomas
    - Rich Unger
    - Daniel van Enckevort
    - Laurence Vanhelsuwe
    - Sylvain Vieujot
    - Jelai Wang
    - Mark Watson
    - Alex Weber
    - Matthew Wright
    - Christian W. Zuckschwerdt
    - Hari 
    - Sam (oldman)

It is possible that I have missed someone on this list, if that
applies to you, please e-mail me. 

Regards,

Dave Gilbert (david.gilbert@object-refinery.com)
JFreeChart Project Leader
