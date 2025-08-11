package com.cpk4.datavisualizer;

import java.util.ArrayList;
import java.util.List;

public interface DataDrivenDataVisualizer {
    /**
     * Set the data source for the visualization
     * @param dataSource The data source to use
     */
    void setDataSource(DataSource dataSource);

    /**
     * Get the data source for the visualization
     * @return The data source used for the visualization
     */
    DataSource getDataSource();

    /**
     * Set the visualization type (e.g. bar chart, line graph, etc.)
     * @param visualizationType The type of visualization to use
     */
    void setVisualizationType(VisualizationType visualizationType);

    /**
     * Get the visualization type
     * @return The type of visualization used
     */
    VisualizationType getVisualizationType();

    /**
     * Set the configuration options for the visualization
     * @param configOptions The configuration options for the visualization
     */
    void setConfigOptions(ConfigOptions configOptions);

    /**
     * Get the configuration options for the visualization
     * @return The configuration options used for the visualization
     */
    ConfigOptions getConfigOptions();

    /**
     * Generate the visualization based on the data and configuration
     * @return A Visualization object representing the generated visualization
     */
    Visualization generateVisualization();

    /**
     * Interface for data sources
     */
    interface DataSource {
        /**
         * Get the data from the source
         * @return A list of data points
         */
        List<DataPoint> getData();
    }

    /**
     * Interface for data points
     */
    interface DataPoint {
        /**
         * Get the x-axis value
         * @return The x-axis value
         */
        double getXValue();

        /**
         * Get the y-axis value
         * @return The y-axis value
         */
        double getYValue();
    }

    /**
     * Enum for visualization types
     */
    enum VisualizationType {
        BAR_CHART,
        LINE_GRAPH,
        SCATTER_PLOT
    }

    /**
     * Class for configuration options
     */
    class ConfigOptions {
        private int width;
        private int height;
        private String title;

        public ConfigOptions(int width, int height, String title) {
            this.width = width;
            this.height = height;
            this.title = title;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * Class for visualizations
     */
    class Visualization {
        private List<DataPoint> dataPoints;
        private VisualizationType type;

        public Visualization(List<DataPoint> dataPoints, VisualizationType type) {
            this.dataPoints = dataPoints;
            this.type = type;
        }

        public List<DataPoint> getDataPoints() {
            return dataPoints;
        }

        public VisualizationType getType() {
            return type;
        }
    }
}